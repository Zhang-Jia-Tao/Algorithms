package edu.princeton.cs.LeetCode.BST;

//相同的树
public class zjt_100 {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isEqual(p,q);
    }

    public boolean isEqual(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        } else if(p == null || q == null){
            //因为会首先检测第一个if条件 如果不满足第一个，但p == null 成立的话，并不会检测q == null是否成立，实际上q肯定不为null 所以一定不是相同的树
            return false;
        } else if(p.val != q.val){
            return false;
        } else {
            boolean left = isEqual(p.left,q.left);
            boolean right = isEqual(p.right,q.right);
            return left && right;
        }
    }


}
