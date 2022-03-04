package edu.princeton.cs.LeetCode.BT;

//翻转二叉树
public class zjt_226 {
    public static void main(String[] args) {

    }

    private class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        return inver(root);
    }

    private TreeNode inver(TreeNode root){
        //base case
        if(root == null){
            return null;
        }

        //前序遍历  ，也可以将这交换的三句代码放在后序遍历的位置
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        inver(root.left);
        inver(root.right);

        return root;
    }

}
