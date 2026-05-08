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
        var pval = p.val;
        var qval = q.val;
        var cur = root;
        while (cur != null) {
            if (pval < cur.val && qval < cur.val) {
                cur = cur.left;
            } else if (pval > cur.val && qval > cur.val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }
}
