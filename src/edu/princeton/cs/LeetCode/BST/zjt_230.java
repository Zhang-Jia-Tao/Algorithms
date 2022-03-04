package edu.princeton.cs.LeetCode.BST;

//二叉搜素数中第k小的元素
public class zjt_230 {

    private int index = 0;      //
    private int value = 0;        //用来保存匹配到第k个的时候的值

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
            this.right = right;
            this.left = left;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        index = k;
        InOrder(root,1);
        return value;
    }

    private void InOrder(TreeNode root,int count){
        //base case
        if(root == null){
            return;
        }

        InOrder(root.left,count+1);
        if(index == count){
            value = root.val;
            return;
        }
        InOrder(root.right,count+1);
    }

}
