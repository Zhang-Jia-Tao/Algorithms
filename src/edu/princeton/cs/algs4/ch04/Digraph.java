package edu.princeton.cs.algs4.ch04;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;

//有向图
public class Digraph {
    private int V;
    private int E;
    private ArrayList<Integer>[] adj;

    public Digraph(int V){
        this.V = V;
        this.E = 0;
        adj = new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i] = new ArrayList<>();
        }
    }

    public Digraph(In in){
        this(in.readInt());
        int E = in.readInt();
        for(int i=0;i<E;i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public Digraph reverse(){   //返回该有向图的一个副本，但将其中所有的边的方向反转
        Digraph R = new Digraph(V);
        for(int i=0;i<V;i++){
            for(int w : adj[i]){
                R.addEdge(w,i);
            }
        }
        return R;
    }
}
