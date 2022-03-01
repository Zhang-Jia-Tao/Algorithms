package edu.princeton.cs.LeetCode.BST;

//二叉查找树
public class zjt_108 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(){}

        public TreeNode(TreeNode left,TreeNode right,int val){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);
    }


    private TreeNode build(int[] nums,int left,int right){
        if(left > right){
            return null;
        }

        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = build(nums,left,mid-1);
        root.right = build(nums,mid+1,right);
        return root;
    }


}
