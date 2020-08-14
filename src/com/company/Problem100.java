package com.company;

import com.company.TreeNode;

public class Problem100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && p!= null) {
            return false;
        }

        if (p != null && p== null) {
            return false;
        }

        if (p == null && q == null) {
            return true;
        }

        if (p.val != q.val) {
            return false;
        }

        if (p.val == q.val)  {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) ;
        }

        return false;
    }
}
