package com.company;

import java.util.*;

public class Problem332 {

    public List<String> findItinerary(List<List<String>> tickets) {

        TreeSet<String> treeSet = initSeq(tickets);
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map1 = new HashMap<>();
        int length = indexArray(treeSet, map, map1);
        int[][] arr = new int[length][length];
        initArray(tickets, map, arr);

        List<String> list = new ArrayList<>();
        list.add("JFK");
        return dfs(arr, list, map, map1, tickets.size() + 1);
    }

    private List<String> dfs(int[][] arr, List<String> path, Map<String, Integer> map, Map<Integer, String> map1, int size ) {

        if (path.size() == size) {
            return path;
        }

        String node = path.get(path.size() - 1);
        int index = map.get(node);
        for (int i = 0; i < arr[index].length; i++) {
            if (arr[index][i] > 0) {
                path.add(map1.get(i));
                arr[index][i]--;

                dfs(arr, path, map, map1, size);


                if (path.size() == size) {
                    return path;
                }
                path.remove(path.size() - 1);
                arr[index][i]++;
            }
        }

        return null;
    }

    private TreeSet<String> initSeq(List<List<String>> tickets) {

        TreeSet<String> result = new TreeSet<>();
        for (List<String> ticket : tickets) {
            for (String node : ticket) {
                result.add(node);
            }
        }

        return result;
    }


    private int indexArray(TreeSet<String> treeSet, Map<String, Integer> map, Map<Integer, String> map1) {
        int i = 0;
        for (String node : treeSet) {
            if (!map.containsKey(node)) {
                map.put(node, i);
                map1.put(i++, node);
            }
        }
        return i;
    }

    private void initArray(List<List<String>> tickets, Map<String, Integer> map, int[][] arr) {
        for (List<String> ticket : tickets) {
            arr[map.get(ticket.get(0))][map.get(ticket.get(1))]++;
        }
    }

    public static void main(String[] args) {
        Problem332 p = new Problem332();
        String[][] arr = new String[][]{{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        List<List<String>> list = new ArrayList<>();
        for (String[] ar : arr) {
            List<String> l = new ArrayList<>();
            for (String str : ar) {
                l.add(str);
            }
            list.add(l);
        }

        List<String> result = p.findItinerary(list);
        for (String str : result) {
            System.out.println(str);
        }
    }
}
