package edu.princeton.cs.LeetCode.BFS;


import java.util.LinkedList;
import java.util.Queue;

//二叉树的最小深度
public class zjt_111 {
    public static void main(String[] args) {

    }

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

    private int depth = 1;

    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return depth;
                } else if(node.left != null){
                    queue.add(node.left);
                } else if(node.right != null){
                    queue.add(node.right);
                } else {
                    //...
                }
            }
            depth++;
        }
        return depth;
    }


}
