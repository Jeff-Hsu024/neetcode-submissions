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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            var size = q.size();
            List<Integer> ls = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                var node = q.poll();
                if (node == null) {
                    continue;
                }
                ls.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
            if (ls.size() > 0) {
                res.add(ls);
            }
        }

        return res;
    }
}
