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
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            var n = s.pop();
            if (n == null) {
                continue;
            }
            if (n.val == subRoot.val && isSame(n, subRoot)) {
                return true;
            }
            s.push(n.left);
            s.push(n.right);
        }

        return false;
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        Stack<Pair<TreeNode, TreeNode>> s = new Stack<>();
        s.push(new Pair<>(a, b));
        while (!s.isEmpty()) {
            var pair = s.pop();
            var n1 = pair.getKey();
            var n2 = pair.getValue();
            if (null == n1 && null == n2) {
                continue;
            }
            if (null == n1 || null == n2 || n1.val != n2.val) {
                return false;
            }
            s.push(new Pair<>(n1.left, n2.left));
            s.push(new Pair<>(n1.right, n2.right));
        }

        return true;
    }
}
