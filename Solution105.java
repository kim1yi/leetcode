public class Solution105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        int size = preorder.length;

        return buildTreeCore(preorder, 0, inorder, 0, size-1);
    }
    
    private TreeNode buildTreeCore(int[] preorder, int preBegin, int[] inorder, int inBegin, int inEnd) {
       
        if (inBegin > inEnd || preBegin > preorder.length-1) {
            return null;
        }        
        TreeNode root = new TreeNode(preorder[preBegin]);
        int index = inBegin;
        for (; index <= inEnd; index++) {
            if (inorder[index] == root.val) {
                break;
            }
        }

        root.left = buildTreeCore(preorder, preBegin+1, inorder, inBegin, index-1);
        root.right = buildTreeCore(preorder, preBegin+index-inBegin+1, inorder, index+1, inEnd);

        //需要明确每次递归到底要返回什么，这里需要返回的是已经构建好了下面的子树的根节点，所以把return放在构建左右子树的后面
        return root;
    }
}