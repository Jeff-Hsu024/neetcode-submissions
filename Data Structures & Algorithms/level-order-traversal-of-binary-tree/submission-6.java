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
        if (null == root) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            var size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                var n = q.poll();
                tmp.add(n.val);
                if (null != n.left) {
                    q.offer(n.left);
                }
                if (null != n.right) {
                    q.offer(n.right);
                }
            }
            res.add(tmp);
        }

        return res;
    }
}
