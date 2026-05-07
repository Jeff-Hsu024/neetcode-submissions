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
        int lrEdge = 0;
        for (int i = 0; i< inorder.length; i++) {
            if (inorder[i] == rootVal) {
                lrEdge = i;
                break;
            }
        }
        

        root.left = buildTree(
            Arrays.copyOfRange(preorder, 1, lrEdge + 1),
            Arrays.copyOfRange(inorder, 0, lrEdge)
        );
        root.right = buildTree(
            Arrays.copyOfRange(preorder, lrEdge + 1, preorder.length),
            Arrays.copyOfRange(inorder, lrEdge + 1, inorder.length)
        );

        return root;
    }
}
