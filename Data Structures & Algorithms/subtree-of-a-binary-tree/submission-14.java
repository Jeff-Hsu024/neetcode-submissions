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
            var node = s.pop();
            if (null == node) {
                continue;
            }
            if (node.val == subRoot.val && isSame(node, subRoot)) {
                return true;
            }

            s.push(node.left);
            s.push(node.right);
        }

        return false;
    }

    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null || a.val != b.val) {
            return false;
        }
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}
