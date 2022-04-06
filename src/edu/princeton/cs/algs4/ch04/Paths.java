package edu.princeton.cs.algs4.ch04;

import edu.princeton.cs.algs4.In;

import java.util.Stack;

//单点路径问题
public class Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public Paths(Graph G,int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(G,w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = v;i!=s;i = edgeTo[i]){
            stack.push(i);
        }
        stack.push(s);
        return stack;
    }


    public static void main(String[] args) {
        Graph G = new Graph(new In("/Users/zhangjiatao/Desktop/algs4-data/tinyCG.txt"));
        Paths paths = new Paths(G,0);
        Stack<Integer> stack = (Stack<Integer>) paths.pathTo(5);
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+"-->");
        }
    }
}
