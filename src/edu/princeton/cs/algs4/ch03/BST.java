package edu.princeton.cs.algs4.ch03;

import java.util.NoSuchElementException;

//二叉查找数
public class BST<Key extends Comparable<Key>,Value> {
    private Node root;

    private class Node {
        private Key key;     //sorted by key
        private Value value; //associated data
        private Node left,right;
        private int size;   //numbers of subtree

        public Node(Key key,Value value,int size){
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public BST(){}

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return size(root);
    }

    private int size(Node root){
        if(root == null)
            return 0;
        else
            return root.size;
    }

    public boolean contains(Key key){
        if(key == null){
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    public Value get(Key key){
        return get(root,key);
    }

    //查找  ---利用的递归
    private Value get(Node x,Key key){
        if(key == null){
            throw new IllegalArgumentException("calls get() with a null key");
        }
        if(x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);
        if(cmp > 0){
            return get(x.right,key);
        } else if(cmp < 0){
            return get(x.left,key);
        } else {
            return x.value;
        }
    }

    public void put(Key key,Value value){
        if(key == null){
            throw new IllegalArgumentException("call put() with a null key");
        }
        if(value == key){
            //delete(key);
            return;
        }
        root = put(root,key,value);
    }

    private Node put(Node x,Key key,Value value){
        if(x == null){
            return new Node(key,value,1);
        }
        int cmp = key.compareTo(x.key);
        if(cmp > 0){
            x.right = put(x.right,key,value);
        } else if(cmp < 0){
            x.left = put(x.left,key,value);
        } else {    //如果相等，则更新Value的值
            x.value = value;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    //寻找最小值
    public Key min(){
        if(isEmpty()){
            throw new NoSuchElementException("calls min() with empty symbol table");
        }
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left == null){
            return x;
        } else {
            return min(x.left);
        }
    }

    //寻找最大值
    public Key max(){
        if(isEmpty()){
            throw new NoSuchElementException("calls max() with empty symbol table");
        }
        return max(root).key;
    }

    private Node max(Node x){
        if(x.right == null){
            return x;
        } else {
            return max(x.right);
        }
    }


    public static void main(String[] args) {
        BST<Character,String> bst = new BST<>();
        bst.put('A',"zjt");
        bst.put('B',"zhangjiatao");
        bst.put('C',"ZJT");
        bst.put('Z',"wudi");
        System.out.println(bst.size());
        System.out.println(bst.min());
        System.out.println(bst.max());
    }
}
