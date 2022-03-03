package edu.princeton.cs.LeetCode.BST;


//二叉树的最大深度
public class zjt_104 {
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

    //存储深度
    int maxdepth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root,1);
        return maxdepth;
    }

    private void traverse(TreeNode root,int depth){
        if(root == null){
            return;
        }
        traverse(root.left,depth+1);
        traverse(root.right,depth+1);
        maxdepth = Math.max(maxdepth,depth);        //后序遍历
    }
}
