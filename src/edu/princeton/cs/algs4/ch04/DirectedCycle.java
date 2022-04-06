package edu.princeton.cs.algs4.ch04;

import java.util.Stack;

//监测有向图中是否包含有向环
public class DirectedCycle {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;
    private boolean[] onStack;


    public DirectedCycle(){

    }

    public static void main(String[] args) {

    }
}
