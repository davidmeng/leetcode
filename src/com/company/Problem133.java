package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem133 {

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Node clone = new Node();
        cloneGraph(node ,clone, new HashMap<>(), new HashSet<>());
        return clone;
    }

    public void cloneGraph(Node node, Node clone,  Map<Integer, Node> map, Set<Integer> set) {

        if (!set.contains(node.val)) {
            if (!map.containsKey(node.val)) {

                clone.val = node.val;
                map.put(clone.val, clone);
                for (Node neighbor : node.neighbors) {
                    if (map.containsKey(neighbor.val)) {
                        clone.neighbors.add(map.get(neighbor.val));
                    } else {
                        Node newClone = new Node();
                        cloneGraph(neighbor, newClone, map, set);
                        clone.neighbors.add(newClone);
                    }
                }
            }
            set.add(node.val);
        }
    }

    public static void main(String[] args) {
        Problem133 p = new Problem133();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.neighbors.add(n2);
        n2.neighbors.add(n1);

        Node n3 = p.cloneGraph(n1);
        System.out.println(n3.val);
    }
}
