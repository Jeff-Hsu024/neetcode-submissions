/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean helper(TreeNode node, long min, long max) {
        if (null == node) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }

        var l = helper(node.left, min, node.val);
        var r = helper(node.right, node.val, max);
        return l && r;
    }
}
