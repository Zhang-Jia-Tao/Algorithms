package edu.princeton.cs.algs4.ch01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//表示固定容量的字符串栈，且不支持迭代
//与书中不同的地方在 对于栈顶的指向
public class FixedCapacityStackOfStrings {

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(100);
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-")){
                stack.push(item);
            } else if (!stack.isEmpty()){
                StdOut.print(stack.pop()+"\t");
            }
        }
        StdOut.print("("+stack.size()+"left on stack)");
    }

    private String[] stack;
    private int top = -1;

    public FixedCapacityStackOfStrings(int capacity){
        this.stack = new String[capacity];
    }

    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }

    public void push(String item){
        if(top == stack.length-1){
            System.out.println("栈满，无法入栈");
            return;
        }
        top++;
        stack[top] = item;
    }

    public String pop(){
        if(isEmpty()){
            System.out.println("栈空，无法出栈");
            return "";
        }
        String res = stack[top];
        top--;
        return res;
    }

    public int size(){
        return top+1;
    }
}
