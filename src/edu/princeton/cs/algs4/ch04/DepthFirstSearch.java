package edu.princeton.cs.algs4.ch04;

import edu.princeton.cs.algs4.In;

//深度优先搜索
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G,int s){ //s为起始定点
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        marked[v] = true;
        count++;
        for(int w : G.adj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
    }

    public int count(){
        return count;
    }

    public boolean marked(int w){
        return marked[w];
    }


    public static void main(String[] args) {
        Graph graph = new Graph(new In(args[0]));
        DepthFirstSearch d = new DepthFirstSearch(graph,0);
        System.out.println(d.count);
    }
}
