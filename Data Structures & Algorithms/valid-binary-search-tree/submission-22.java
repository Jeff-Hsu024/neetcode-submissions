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
    record BSTValidDto(TreeNode node, long min, long max) {
        public boolean valid() {
            if (null == node) {
                return true;
            }
            if (node.val <= min || node.val >= max) {
                return false;
            }
            return true;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }
        Deque<BSTValidDto> dq = new ArrayDeque<>();
        dq.offer(new BSTValidDto(root, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!dq.isEmpty()) {
            var dto = dq.pop();
            if (dto.node() == null) {
                continue;
            }
            if (!dto.valid()) {
                return false;
            }
            dq.offer(new BSTValidDto(dto.node().left, dto.min(), dto.node().val));
            dq.offer(new BSTValidDto(dto.node().right, dto.node().val, dto.max()));
        }

        return true;
    }
}
