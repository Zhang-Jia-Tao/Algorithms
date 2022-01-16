package edu.princeton.cs.algs4.ch01;


import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Reverse {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        while(!StdIn.isEmpty()){
            stack.push(StdIn.readInt());
        }
        for(int i : stack){
            StdOut.print(i+"\t");
        }
    }
}
