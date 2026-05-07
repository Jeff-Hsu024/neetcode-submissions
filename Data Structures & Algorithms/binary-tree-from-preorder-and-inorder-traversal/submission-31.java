class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inIndex = 0; 
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }

        // 左子樹個數 = inIndex - inStart
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        // 右子樹起點 = 原本起點 + 左子樹個數 + 1 (根)
        root.right = helper(preStart + (inIndex - inStart) + 1, inIndex + 1, inEnd, preorder, inorder);
        
        return root;
    }
}