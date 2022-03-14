package edu.princeton.cs.LeetCode.BFS;

import java.util.LinkedList;
import java.util.Queue;

//对称二叉树
//通过了134
public class zjt_101 {
    public static void main(String[] args) {

    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){};
        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        while(!queue.isEmpty()){

            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

            size = queue.size();
            if(size%2 != 0){
                return false;
            }
            //利用数组保存每层的数据
            int[] data = new int[size];
            int i=0;
            for(TreeNode node : queue){
                data[i++] = node.val;
            }
            //判断是否对称
            boolean flag = isSym(data);
            if(!flag){
                return false;
            }
        }

        return true;
    }

    private Boolean isSym(int[] data){
        int i = 0;
        int j = data.length - 1;
        while (i>j){
            if(data[i] == data[j]){
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
