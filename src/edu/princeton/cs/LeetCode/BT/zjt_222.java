package edu.princeton.cs.LeetCode.BT;

//完全二叉树的结点个数
public class zjt_222 {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
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

    private int num = 0;

    public int countNodes(TreeNode root) {
        if(root == null){
            return num;
        }
        count(root);
        return num;
    }

    private void count(TreeNode root){
        if(root == null){
            return;
        }
        num++;
        count(root.left);
        count(root.right);
    }
}
