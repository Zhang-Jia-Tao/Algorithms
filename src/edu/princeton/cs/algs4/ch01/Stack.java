package edu.princeton.cs.algs4.ch01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

//下压堆栈(链表实现)
public class Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;
    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        if(N == 0 || first == null)
            return true;
        return false;
    }

    public int size(){
        return N;
    }

    //从表头添加结点，满足栈的先进后出的特点
    public void push(Item item){
        Node oldnode = first;
        first = new Node();
        first.item = item;
        first.next = oldnode;
        N++;
    }

    public Item pop(){
        Item res = first.item;
        first = first.next;
        N--;
        return res;
    }


    //实现可迭代
    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Item next() {
            Item item = node.item;
            node = node.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!"-".equals(item)){
                stack.push(item);
            } else if(!stack.isEmpty()){
                StdOut.print(stack.pop()+"\t");
            }
        }
        StdOut.print("( "+stack.size()+" left the stack )");
        StdOut.println();
        for(String s : stack){  //验证是否是后进先出
            StdOut.print(s+"\t");
        }
    }
}
