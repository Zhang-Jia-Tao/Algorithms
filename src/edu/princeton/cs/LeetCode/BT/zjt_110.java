package edu.princeton.cs.LeetCode.BT;

//平衡二叉树
public class zjt_110 {
    public static void main(String[] args) {

    }
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(height(root.left)-height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right)) + 1;
    }




}
