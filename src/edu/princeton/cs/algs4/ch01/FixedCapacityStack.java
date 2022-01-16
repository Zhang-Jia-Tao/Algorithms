package edu.princeton.cs.algs4.ch01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//范型定容栈
public class FixedCapacityStack<Item> {

    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(100);
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!"-".equals(item)){
                stack.push(item);
            } else if(!stack.isEmpty()){
                StdOut.print(stack.pop()+"\t");
            }
        }
        StdOut.print("( "+stack.size()+" left on stack )");
    }

    private Item[] stack;
    private int N;

    public FixedCapacityStack(int cap){
        stack = (Item[]) new Object[cap];
    }

    public boolean isEmpty(){
        if(N == 0)
            return true;
        return false;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        stack[N++] = item;
    }

    public Item pop(){
        return stack[--N];
    }
}
