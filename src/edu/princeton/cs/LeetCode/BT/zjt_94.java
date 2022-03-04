package edu.princeton.cs.LeetCode.BT;


import java.util.ArrayList;
import java.util.List;

//中序遍历
public class zjt_94 {
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

    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        InOrder(root);
        return list;
    }

    private void InOrder(TreeNode root){
        if(root == null){
            return;
        }

        InOrder(root.left);
        list.add(root.val);
        InOrder(root.right);
    }

}
