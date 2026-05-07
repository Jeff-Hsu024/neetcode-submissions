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
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        var rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int edge = findIndex(inorder, rootVal);
        root.left = buildTree(
            Arrays.copyOfRange(preorder, 1, edge + 1), Arrays.copyOfRange(inorder, 0, edge));
        root.right = buildTree(Arrays.copyOfRange(preorder, edge + 1, preorder.length),
            Arrays.copyOfRange(inorder, edge + 1, inorder.length));

        return root;
    }

    int findIndex(int[] ary, int target) {
        int res = -1;
        for (int i = 0; i < ary.length; i++) {
            if (ary[i] == target) {
                return i;
            }
        }

        return res;
    }
}
