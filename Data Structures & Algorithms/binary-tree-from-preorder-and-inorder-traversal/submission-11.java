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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = new ArrayList<>();
        for (var n : preorder) {
            pre.add(n);
        }
        List<Integer> in = new ArrayList<>();
        for (var n : inorder) {
            in.add(n);
        }
        return buildTree(pre, in);
    }

    public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0 || inorder.size() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder.get(0));
        int m = inorder.indexOf(preorder.get(0));
        root.left = buildTree(preorder.subList(1, m + 1), inorder.subList(0, m));
        root.right = buildTree(preorder.subList(m + 1, preorder.size()), inorder.subList(m + 1, inorder.size()));
        return root;
    }
}
