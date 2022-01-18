package edu.princeton.cs.examples;

import java.util.Iterator;

//基于数组实现双向队列
public class Ex1_3_33_Array<Item> implements Iterable<Item>{
    private Item[] a = (Item[]) new Object[1];
    private int N;

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    private void resize(int max){
        Item[] items =(Item[]) new Object[max];
        for(int i=0;i<N;i++){
            items[i] = a[i];
        }
        a = items;
    }

    //从左侧添加数据
    public void pushLeft(Item item){
        if(N == a.length){
            resize(2*a.length);
        }
        //数组中的数据整体往后移
        for(int i=N-1;i>=0;i--){
            a[i+1] = a[i];
        }
        a[0] = item;
        N++;
    }

    //从右侧添加数据
    public void pushRight(Item item){
        if(N == a.length){
            resize(2*a.length);
        }
        a[N++] = item;
    }

    //从左侧弹出数据
    public Item popLeft(){
        Item res = a[0];
        for(int i=0;i<N-1;i++){
            a[i] = a[i+1];
        }
        N--;
        if(N>0 && N == a.length/4){
            resize(a.length/2);
        }
        return res;
    }

    public Item popRight(){
        Item item = a[--N];
        if(N>0 && N==a.length/4)
            resize(a.length/2);
        return item;

    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item>{
        private int i = N;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }

    public static void main(String[] args) {
        Ex1_3_33_Array<Integer> dequeue = new Ex1_3_33_Array<>();
        dequeue.pushLeft(11);
        dequeue.pushLeft(12);
        dequeue.pushLeft(13);
        dequeue.pushLeft(14);

        System.out.println(dequeue.size());

        System.out.println(dequeue.popLeft());
        System.out.println(dequeue.popRight());

    }
}
