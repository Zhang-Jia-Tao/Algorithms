package edu.princeton.cs.algs4.ch04;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class EdgeWeightedGraph {
    private final int V;    //顶点总数
    private int E;    //边的总数
    private Bag<Edge>[] adj;    //临接表

    public EdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for(int i=0;i<V;i++){
            adj[i] = new Bag<>();
        }
    }

    public EdgeWeightedGraph(In in) throws Exception{
        this(in.readInt());
        int E = in.readInt();
        for(int i=0;i<E;i++){
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();

            Edge edge = new Edge(v,w,weight);
            this.addEdge(edge);
        }
    }

    public void addEdge(Edge edge) throws Exception{
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        this.E++;
    }

    public int V(){
        return V;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges() throws Exception{
        Bag<Edge> b = new Bag<>();
        for(int i=0;i<V;i++){
            for(Edge e:adj[i]){
                if(e.other(i) > i){
                    b.add(e);
                }
            }
        }
        return b;
    }
}
