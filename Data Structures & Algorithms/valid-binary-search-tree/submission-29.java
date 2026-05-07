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
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean valid(TreeNode node, long min, long max) {
        if (null == node) {
            return true;
        }
        if (node.val >= max || node.val <= min) {
            return false;
        }
        var l = valid(node.left, min, node.val);
        var r = valid(node.right, node.val, max);
        return l && r;
    }
}
