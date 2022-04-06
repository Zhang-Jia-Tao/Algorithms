package edu.princeton.cs.algs4.ch04;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

//最小生成树
public class LazyPrimMST {
    private boolean[] marked;       //最小生成树的顶点
    private Queue<Edge> mst;        //最小生成树的边
    private MinPQ<Edge> pq;         //横切边(包括失效的边)

    public LazyPrimMST(EdgeWeightedGraph G) throws Exception{
        pq = new MinPQ<>();
        marked = new boolean[G.V()];
        mst = new Queue<>();

        visit(G,0);

        while(!pq.isEmpty()){
            Edge e = pq.delMin();       //循环终止的语句
            int v = e.either();
            int w = e.other(v);
            if(marked[v] && marked[w])  //跳过失效的边
                continue;
            if(!marked[v])
                visit(G,v);
            if(!marked[w])
                visit(G,w);
        }

    }

    public void visit(EdgeWeightedGraph G,int v) throws Exception{
        //标记顶点V并将所有连接v和未被标记顶点的加入pq
        marked[v] = true;
        for(Edge e : G.adj(v)){
            if(!marked[e.other(v)])     //如果另一顶点没有加入，则将他们之间的边加入优先队列
                pq.insert(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        double total = 0.0;
        for(Edge e : mst){
            total += e.weight();
        }
        return total;
    }


    public static void main(String[] args) throws Exception{
        In in = new In(args[0]);
        EdgeWeightedGraph G;
        G = new EdgeWeightedGraph(in);

        LazyPrimMST mst = new LazyPrimMST(G);

        for(Edge e : mst.edges()){
            StdOut.println(e);
        }

        System.out.println(mst.weight());
    }
}
