package edu.princeton.cs.lanqiao.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//无向图
public class Graph {
    int V;      //顶点个数
    int E;      //边的个数
    ArrayList<Integer>[] edge;  //存放边

    public Graph(int V){        //邻接表
        this.V = V;
        edge = new ArrayList[V];
        for(int i=0;i<V;i++){
            edge[i] = new ArrayList<>();
        }
    }

    public Graph(Scanner scanner){
        this(scanner.nextInt());  //调用同一类的含一个整形参数的构造方法
        int E = scanner.nextInt();
        for(int i=0;i<E;i++){
            addEdge(scanner.nextInt(),scanner.nextInt());
        }
    }

    public void addEdge(int v,int w){
        edge[v].add(w);
        edge[w].add(v);
        this.E++;
    }

    public Iterable<Integer> adj(int v){
        return edge[v];
    }


    public int V(){
        return V;
    }




}
