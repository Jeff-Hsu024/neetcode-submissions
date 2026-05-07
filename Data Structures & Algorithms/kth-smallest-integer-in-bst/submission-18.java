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
    public int kthSmallest(TreeNode root, int k) {
        if (null == root) {
            return -1;
        }

        Stack<TreeNode> s = new Stack<>();
        var cur = root;
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            var node = s.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            // look up last node right side to go left.
            cur = node.right;
        }
        return -1;
    }
}
