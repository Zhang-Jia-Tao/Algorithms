package edu.princeton.cs.lanqiao.test;

import java.util.Scanner;
import java.util.Stack;

//搜索路径
public class path {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;  //起点

    public path(Graph graph,int s){
        this.s = s;     //表明要查找的路径问题是寻找与s联通的顶点
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V];
        dfs(graph,s);
    }

    public void dfs(Graph graph,int v){
        marked[v] = true;
        for(int ver : graph.adj(v)){
            if(!marked[ver]){
                edgeTo[ver] = v;
                dfs(graph,ver);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }


    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> stack =  new Stack<>();
        for(int x = v; x != s; x= edgeTo[x]){
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph(scanner);
        path path = new path(graph,0);
        for(int i : path.pathTo(4)){
            System.out.print(i + "\t");
        }

        Stack<Integer> stack = (Stack<Integer>) path.pathTo(4);
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+"\t");
        }
    }

}
