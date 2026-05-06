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

        Stack<Pair<TreeNode, TreeNode>> s = new Stack<>();
        s.push(new Pair<>(root, subRoot));
        while (!s.isEmpty()) {
            var last = s.pop();
            var rn = last.getKey();
            if (rn == null) {
                continue;
            }
            var sn = last.getValue();
            if (rn.val == sn.val && isSame(rn, sn)) {
                return true;
            }
            s.push(new Pair<>(rn.right, sn));
            s.push(new Pair<>(rn.left, sn));
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
