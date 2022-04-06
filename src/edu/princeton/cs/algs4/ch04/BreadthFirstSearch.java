package edu.princeton.cs.algs4.ch04;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.ch01.Queue;

//广度优先搜索
public class BreadthFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;        //到达该顶点的已知该路径上的最后一个顶点
    private int s;              //起点

    public BreadthFirstSearch(Graph G,int s){
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }

    private void bfs(Graph G,int v){
        Queue<Integer> queue = new Queue<>();
        marked[v] = true;
        queue.enqueue(s);

        while(!queue.isEmpty()){
            Integer vertiex = queue.dequeue();
            for(int w : G.adj(vertiex)){
                if(!marked[w]){
                    queue.enqueue(w);
                    edgeTo[w] = vertiex;
                    marked[w] = true;
                }
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
        for(int i=v; i!=s;i = edgeTo[i]){
            stack.push(i);
        }
        stack.push(s);
        return stack;
    }
}
