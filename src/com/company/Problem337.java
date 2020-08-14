package com.company;

import java.util.HashMap;
import java.util.Map;

public class Problem337 {

    public static void main(String[] args) {
        Problem337 p = new Problem337();
        TreeNode root = TreeNode.initTreeNode(new Integer[]{3,4,5,1,3,null,1});
        System.out.println(p.rob(root));
    }

    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return rot(root, true, new HashMap<>(), new HashMap<>());
    }

    public int rot(TreeNode root, boolean canRob, Map<TreeNode, Integer> robMap, Map<TreeNode, Integer> nrobMap) {
        if (canRob) {
            if (robMap.containsKey(root)) {
                return robMap.get(root);
            }
        } else {
            if (nrobMap.containsKey(root)) {
                return robMap.get(root);
            }
        }

        if (root == null) {
            return 0;
        }

        if (canRob) {
            int sum = Math.max(root.val + rot(root.left, false, robMap, nrobMap) + rot(root.right, false, robMap, nrobMap),
                    rot(root.left, true, robMap, nrobMap) + rot(root.right, true, robMap, nrobMap));
            robMap.put(root, sum);
            return sum;
        } else {
            int sum = rot(root.left, true, robMap, nrobMap) + rot(root.right, true, robMap, nrobMap);
            nrobMap.put(root, sum);
            return sum;
        }
    }
}
