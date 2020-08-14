package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem207 {

    public static void main(String[] args) {
        Problem207 p = new Problem207();
        System.out.println(p.canFinish(3, new int [][] {{1,0},{1,2},{0,1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Node> map = initMap(numCourses, prerequisites);
        Set<Node> set = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        for (Node node : map.values()) {
            if (!visited.contains(node)) {
                set.clear();
                set.add(node);
                if (isCircle(node, set, visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    private Map<Integer, Node> initMap(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            Node node = new Node();
            node.index = i;
            map.put(i, node);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][0]).next.add(map.get(prerequisites[i][1]));
        }

        return map;
    }

    private boolean isCircle(Node node, Set<Node> set, Set<Node> visited) {

        boolean isCircle = false;
        visited.add(node);
        for (Node t : node.next) {
            if (set.contains(t)) {
                return true;
            } else {
                set.add(t);
                isCircle = isCircle(t, set, visited)||isCircle;
                if (isCircle) {
                    return isCircle;
                }
                set.remove(t);
            }
        }
        return false;
    }


    private class Node {
        int index;
        Set<Node> next = new HashSet<>();
    }
}
