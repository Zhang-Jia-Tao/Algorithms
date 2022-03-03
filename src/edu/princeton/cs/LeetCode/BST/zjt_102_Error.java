package edu.princeton.cs.LeetCode.BST;

import edu.princeton.cs.algs4.ch01.Stack;

import java.util.*;

//层序遍历
public class zjt_102_Error {


    public static void main(String[] args) {

    }

    private class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();  //队列用来存储结点
        queue.add(root);                    //先将根结点入队列
        TreeNode temp = root;
        while (!queue.isEmpty()){               //队列不空就继续循环
            List<Integer> list = new ArrayList<>();         //内存超出限制的原因应该在这里，因为每次的循环都会创建一个List
            list.add(queue.remove().val);
            lists.add(list);

            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }
        }

        return lists;
    }


}
