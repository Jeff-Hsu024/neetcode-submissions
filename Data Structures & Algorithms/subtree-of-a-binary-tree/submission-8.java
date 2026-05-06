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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        // remain root and subroot are not null.
        // still need exarct
        if (isSame(root, subRoot)) {
            return true;
        }
        var r = isSubtree(root.right, subRoot);
        var l = isSubtree(root.left, subRoot);
        return r || l;
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null || a.val != b.val) {
            return false;
        }
        var r = isSame(a.right, b.right);
        var l = isSame(a.left, b.left);
        return r && l;
    }
}
