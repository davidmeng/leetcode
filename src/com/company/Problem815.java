package com.company;

import java.util.*;

public class Problem815 {

    public static void main(String[] args) {
        Problem815 p = new Problem815();
        System.out.println(p.numBusesToDestination(new int [][]{{1,2,7},{3,6,7}}, 1 ,  6));
    }

    public int numBusesToDestination(int[][] routes, int S, int T) {

        if (routes.length==0) {
            return -1;
        }

        if (S == T) {
            return 0;
        }

        boolean [][] bools = getRoutes(routes, S, T);
        /*for (int i = 0 ; i<bools.length; i++) {
            for (int j = 0; j < bools[i].length; j++) {

                System.out.printf("i:%d, j:%d = %s\n", i, j, String.valueOf(bools[i][j]));
            }
            System.out.println();
        }*/

        LinkedList<Integer> stations = new LinkedList<>();
        LinkedList<Integer> steps = new LinkedList<>();

        Set<Integer> visited = new HashSet<>();

        steps.addLast(0);
        stations.addLast(0);
        visited.add(0);

        int now = stations.pollFirst();
        int nowStep = steps.pollFirst();
        while (now != bools.length-1) {
            for (int i = 0 ; i<bools.length ; i++) {
                if (bools[now][i] && !visited.contains(i)) {
                    steps.addLast(nowStep+1);
                    stations.addLast(i);
                    visited.add(i);
                }
            }

            if (stations.isEmpty()) {
                return -1;
            }

            now = stations.pollFirst();
            nowStep = steps.pollFirst();
        }

        if (now == bools.length-1) {
            return nowStep-1;
        }


        return -1;
    }

    public boolean [][] getRoutes (int[][] routes, int start, int end) {
        boolean [][] r = new boolean [routes.length + 2][routes.length + 2];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0 ; i<routes.length; i++) {
            for (int j = 0; j<routes[i].length ; j++) {
                if (!map.containsKey(routes[i][j])){
                    map.put(routes[i][j], new ArrayList<>());
                }
                map.get(routes[i][j]).add(i+1);
            }
        }

        for (int key: map.keySet()) {
            List<Integer> list = map.get(key);
            for (int i = 0 ; i<list.size(); i++) {
                for (int j = i+1; j<list.size() ; j++) {
                    r[list.get(i)][list.get(j)] = true;
                    r[list.get(j)][list.get(i)] = true;
                }
            }
        }

        List<Integer> list = map.get(start);
        for (int i = 0 ; i<list.size(); i++) {
            r[0][list.get(i)] = true;
        }

        list = map.get(end);
        for (int i = 0 ; i<list.size(); i++) {
            r[r.length-1][list.get(i)] = true;
            r[list.get(i)][r.length-1] = true;
        }


        return r;
    }
}
