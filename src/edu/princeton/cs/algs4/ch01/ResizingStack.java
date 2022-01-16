package edu.princeton.cs.algs4.ch01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    //是否为空
    public boolean isEmpty(){
        if(N==0)
            return true;
        return false;
    }

    //栈中数量
    public int size(){
        return N;
    }

    //将栈移动到一个大小为max的新数组  --> 将栈中用于存储数据的数组转移为更大的数组
    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i=0;i<N;i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item){
        if(N==a.length){
            resize(2*a.length);
        }
        a[N++] = item;
    }

    public Item pop(){
        Item item = a[--N];
        a[N] = null;
        if(N>0 && N==a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }


    private class ReverseArrayIterator implements Iterator<Item> {
        //支持后进先出的迭代
        private int i=N;

        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove(){}
    }

    public static void main(String[] args) {
        ResizingStack<String> stack = new ResizingStack<>();
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
