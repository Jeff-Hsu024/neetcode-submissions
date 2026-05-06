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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<Pair<TreeNode, TreeNode>> s = new Stack<>();
        s.push(new Pair<>(p, q));

        while (!s.isEmpty()) {
            var last = s.pop();
            var a = last.getKey();
            var b = last.getValue();
            if (a == null && b != null) {
                return false;
            }
            if (a != null && b == null) {
                return false;
            }
            if (a == null && b==null) {
                continue;
            }

            if (a.val != b.val) {
                return false;
            }
            if (a.left != null || b.left != null) {
                s.push(new Pair<>(a.left, b.left));
            }
            if (a.right != null || b.right != null) {
                s.push(new Pair<>(a.right, b.right));
            }
        }

        return true;
    }
}
