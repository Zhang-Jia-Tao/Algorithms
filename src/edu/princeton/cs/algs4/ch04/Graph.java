package edu.princeton.cs.algs4.ch04;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

//图的存储结构 --> 使用临接表
public class Graph {
    private final int V;                  //顶点(Vertex)数目
    private int E;                  //边(Edge)数目
    private Bag<Integer>[] adj;     //临接表

    public Graph(int v){
        this.V = v;
        this.E = 0;
        this.adj = new Bag[v];
        for(int i=0;i<V;i++){
            adj[i] = new Bag<>();
        }
    }

    public Graph(In in){
        this(in.readInt());     //调用 public Graph(int v) 构造方法
        int E = in.readInt();
        for(int i=0;i<E;i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    //返回边数
    public int E(){return E;}
    //返回顶点数目
    public int V(){return V;}

    //返回和v相邻的所有定点
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    //计算v的度数
    public int degree(int v){
        int count = 0;
        for(int i : adj(v)){
            count++;
        }
        return count;
    }

    //计算所有顶点的最大度数
    public int maxDegree(){
        int maxDegree = -1;
        for(int i=0;i<V;i++){
            maxDegree = Math.max(degree(i),maxDegree);
        }
        return maxDegree;
    }

    //计算所有自环的个数
    public int numberOfSelfLoops(){
        int count = 0;
        for(int i=0;i<V;i++){
            for(int j : adj(i)){
                if(i==j){
                    count++;
                }
            }
        }
        return count/2;
    }

    //图的临接表的字符串表示
    @Override
    public String toString(){
        String s = V + " vertices " + E + " edges \n";
        for(int i=0;i<V;i++){
            s += i + ": ";
            for(int j : adj(i)){
                s += j + " ";
            }
            s += "\n";
        }
        return s;
    }


    public static void main(String[] args) {
        Graph graph = new Graph(new In(args[0]));

        System.out.println(graph.V);
        System.out.println(graph.E);
        System.out.println(graph.degree(1));
        System.out.println(graph.maxDegree());
        System.out.println(graph.numberOfSelfLoops());
        System.out.println(graph);
    }
}
