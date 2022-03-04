package edu.princeton.cs.LeetCode.BT;


//最大二叉树
public class zjt_654 {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums,0,nums.length-1);
    }

    private TreeNode maxTree(int[] nums,int lo,int hi){
        //base case
        if(lo > hi){
            return null;
        }

        int rank = -1;   //记录最大值的下标
        int max = Integer.MIN_VALUE;    //用于记录最大值
        for(int i=lo;i<=hi;i++){
           if(max < nums[i]){
               max = nums[i];
               rank = i;
           }
        }
        TreeNode root = new TreeNode(max);      //创建结点

        root.left = maxTree(nums,lo,rank-1);
        root.right = maxTree(nums,rank+1,hi);

        return root;
    }
}
