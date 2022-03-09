package edu.princeton.cs.LeetCode.BFS;

import javax.xml.soap.Node;
import java.util.*;

//二叉树的层序遍历
public class zjt_107 {
    public static void main(String[] args) {

    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int val){
            this.val = val;
        }
        public TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Stack<List<Integer>> stack = new Stack<>();    //栈
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();        //每一层使用list保存
            int size = queue.size();

            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

            //for循环结束，将其添加到stack中
            stack.push(list);
        }

        //利用栈的性质 先进后出(后进先出)
        while(!stack.isEmpty()){
            lists.add(stack.pop());
        }

        return lists;

    }




}
