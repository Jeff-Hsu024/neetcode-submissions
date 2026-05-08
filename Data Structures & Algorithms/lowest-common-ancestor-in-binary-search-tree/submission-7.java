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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var cur = root;
        var pval = p.val;
        var qval = q.val;

        while (cur != null) {
            var curval = cur.val;
            if (pval > curval && qval > curval) {
                // at right
                cur = cur.right;
            } else if (pval < curval && qval < curval) {
                cur = cur.left;
            } else {
                return cur;
            }
        }

        return null;
    }
}
