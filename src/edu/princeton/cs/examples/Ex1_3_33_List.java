package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

//基于双向链表 实现双向队列
public class Ex1_3_33_List<Item> implements Iterable<Item>{

    private Node first;
    private Node last;
    private int N = 0;
    private class Node {
        Item item;
        Node up;
        Node next;
    }

    public boolean isEmpty(){
        if(N == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return N;
    }

    //向左端添加一个新元素
    public void pushLeft(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        if(isEmpty()){
            last = first;
        } else {
            first.next = oldfirst;
            oldfirst.up = first;
        }
        N++;
    }

    //向右端添加一个新元素
    public void pushRight(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if(isEmpty()){
            first = last;
        } else {
            oldlast.next = last;
            last.up = oldlast;
        }
        N++;
    }

    //从左端删除一个元素
    public Item popLeft(){
        Item item = first.item;
        first = first.next;
        if(first != null){
            first.up = null;
        }
        N--;
        return item;
    }

    //从右端删除一个元素
    public Item popRight(){
        Item item = last.item;
        last = last.up;
        if(last != null){
            last.next = null;
        }
        N--;
        return item;
    }

    //实现可迭代
    @Override
    public Iterator<Item> iterator() {
        return new DequeueIterator<>();
    }

    private class DequeueIterator<Item> implements Iterator<Item> {
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Ex1_3_33_List<String> deque = new Ex1_3_33_List<>();
        deque.pushLeft("is");
        deque.pushLeft("zjt");
        deque.pushRight("a");
        deque.pushRight("IT");

        for(String s : deque){
            StdOut.print(s+"\t");
        }

        System.out.print("\n=====test pop=====\n");
        System.out.println(deque.popLeft());
        System.out.println(deque.popRight());
        System.out.println(deque.popRight());
        System.out.println(deque.popLeft());
        //ystem.out.println(deque.popLeft()); ----> NullPointerException
    }
}
