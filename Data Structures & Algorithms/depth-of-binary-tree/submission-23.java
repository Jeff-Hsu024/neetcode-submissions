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
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int res = 0;
        Stack<Pair<TreeNode, Integer>> s = new Stack<>();
        s.push(new Pair<>(root, 1));
        while (!s.isEmpty()) {
            var last = s.pop();
            var n = last.getKey();
            var d = last.getValue();
            res = Math.max(res, d);
            if (null != n.left) {
                s.push(new Pair<>(n.left, d + 1));
            }
            if (null != n.right) {
                s.push(new Pair<>(n.right, d + 1));
            }
        }

        return res;
    }
}
