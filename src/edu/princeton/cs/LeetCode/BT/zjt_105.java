package edu.princeton.cs.LeetCode.BT;

//从前序与中序遍历序列构造二叉树
public class zjt_105 {
    public static void main(String[] args) {

    }

    private int preindex = 0;

    private class TreeNode{
        int val;
        TreeNode left,right;
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,preorder.length-1);
    }

    private TreeNode build(int[] preorder,int[] inorder,int lo,int hi){
        if(lo > hi){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preindex]);

        int floor = -1; //用于存放inorder中的下标
        //查找preorder[preindex]的值在inorder中的下标
        for(int i=lo;i<=hi;i++){
            if(preorder[preindex] == inorder[i]){
                floor = i;
                break;
            }
        }

        preindex++;

        root.left = build(preorder,inorder,lo,floor-1);
        root.right = build(preorder,inorder,floor+1,hi);

        return root;
    }
}
