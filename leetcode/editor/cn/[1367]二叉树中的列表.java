//给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。 
//
// 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 
//。 
//
// 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,null
//,1,3]
//输出：true
//解释：树中蓝色的节点构成了与链表对应的子路径。
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,nu
//ll,1,3]
//输出：true
// 
//
// 示例 3： 
//
// 输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
//null,1,3]
//输出：false
//解释：二叉树中不存在一一对应链表的路径。
// 
//
// 
//
// 提示： 
//
// 
// 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。 
// 链表包含的节点数目在 1 到 100 之间。 
// 二叉树包含的节点数目在 1 到 2500 之间。 
// 
// Related Topics 树 链表 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {

        Map<TreeNode, TreeNode> map = init(root, new HashMap<TreeNode, TreeNode>());
        List<Integer> list = init(head);

        return process(map, list, list.size() - 1, root);
    }

    public boolean process(Map<TreeNode, TreeNode> map, List<Integer> list, int index, TreeNode node) {
        if (this.find(map, list, index, node)) {
            return true;
        }

        if (node.left != null) {
            return process(map, list, index, node.left);
        }

        if (node.right != null) {
            return process(map, list, index, node.right);
        }

        return false;
    }

    public boolean find(Map<TreeNode, TreeNode> map, List<Integer> list, int index, TreeNode node) {

        if (node == null) {
            return false;
        }

        if (index == 0 && list.get(0) == node.val) {
            return true;
        }

        if (node.val == list.get(index)) {
            return find(map, list, --index, map.get(node));
        } else {
            return false;
        }
    }

    public Map<TreeNode, TreeNode> init(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root.left != null) {
            map.put(root.left, root);
            init(root.left, map);
        }

        if (root.right != null) {
            map.put(root.right, root);
            init(root.right, map);
        }

        return map;
    }

    public List<Integer> init(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return list;
    }

    public static void main(String[] args) {

    }


}
//leetcode submit region end(Prohibit modification and deletion)
