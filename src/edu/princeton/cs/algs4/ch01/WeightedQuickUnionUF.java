package edu.princeton.cs.algs4.ch01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//加权union-find算法
public class WeightedQuickUnionUF {
    private int[] id;   //父链接数组(由触点索引)
    private int[] sz;   //由触点索引的 各个根结点所对应的分量的大小
    private int count;  //连通分量的数量

    public WeightedQuickUnionUF(int N){
        count = N;
        id = new int[N];
        for(int i=0;i<N;i++){
            id[i] = i;
        }

        sz = new int[N];
        for(int i=0;i<N;i++){
            sz[i] = 1;
        }
    }

    public int count(){
        return count;
    }

    public int find(int p){
        while(p != id[p])
            p = id[p];
        return p;
    }


    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    public void union(int p,int q){
        int i = find(p);
        int j = find(q);

        if(i == j)
            return;

        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public static void main(String[] args) {
        int N;
        N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);

        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q))
                continue;
            uf.union(p,q);
            StdOut.println(p+"\t"+q);
        }
        StdOut.println(uf.count()+" components");
    }
}
