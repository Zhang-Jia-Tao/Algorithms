package edu.princeton.cs.lanqiao.test;

import java.util.LinkedList;
import java.util.Queue;

//广度优先搜索
public class bfs {
    private boolean[] marked;
    private Queue<Integer> queue;

    public bfs(Graph graph,int s){
        marked = new boolean[graph.V()];
        queue = new LinkedList<>();
        queue.add(s);
        marked[s] = true;
    }

    private void bfs(Graph graph){
        int v = -1;
        while(!queue.isEmpty()){
            v = queue.poll();
            for(int w : graph.adj(v)){
                if(!marked[w]){
                    queue.add(v);
                    marked[w] = true;
                }
            }
        }
    }

    public boolean isConnected(int v){
        return marked[v];
    }
}
