package edu.princeton.cs.lanqiao.test;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ch04.Graph;

import java.util.Scanner;

//深度优先搜索
public class dfs {
    public static boolean[] marked;
    public static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        edu.princeton.cs.lanqiao.test.Graph graph = new edu.princeton.cs.lanqiao.test.Graph(scanner);
        dfs(graph,0);
        System.out.println(count);
    }

    public static void dfs(edu.princeton.cs.lanqiao.test.Graph graph, int s){
        marked = new boolean[graph.V()];  //创建一个标记数组 该数组的作用是标记结点的访问情况
        dfs_s(graph,s);
    }

    private static void dfs_s(edu.princeton.cs.lanqiao.test.Graph graph, int v){
        marked[v] = true;
        count++;
        for(int vertiex : graph.adj(v)){
            if(!marked[vertiex]){
                dfs_s(graph,vertiex);
            }
        }
    }

    private static void dfs_ss(Graph G,int v){  //深度优先搜索的精华所在
        marked[v] = true;
        count++;
        for(int vertiex : G.adj(v)){        //用到的adj方法
            dfs_ss(G,vertiex);
        }
    }

}
