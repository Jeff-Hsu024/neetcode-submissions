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
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        Stack<TreeNode> dq = new Stack<>();
        dq.push(root);
        while (!dq.isEmpty()) {
            var node = dq.pop();
            if (node == null) {
                continue;
            }
            var l = node.left;
            var r = node.right;
            node.right = l;
            node.left = r;
            dq.push(l);
            dq.push(r);
        }

        return root;
    }
}
