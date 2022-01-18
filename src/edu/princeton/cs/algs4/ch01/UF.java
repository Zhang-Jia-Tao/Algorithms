package edu.princeton.cs.algs4.ch01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private int[] id;  //分量id(以触点作为索引)
    private int count;  //分量数量

    public UF(int N){   //初始化分量id数组
        count = N;
        id = new int[N];
        for(int i=0;i<N;i++){
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    //qucik-find算法 一种方法是保证当且仅当id[p]等于id[q]时p和q是连通的
    public int find(int p){
        return id[p];
    }

    public void union(int p,int q){
        int pID = find(p);
        int qID = find(q);

        if(pID == qID){   //总感觉这一步 在当前的例子下是多次一举的
            return;
        }

        for(int i=0;i<id.length;i++){
            if(id[i] == pID){
                id[i] = qID;
            }
        }
        count--;
    }


    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q))
                continue;
            uf.union(p,q);
            StdOut.println(p+"\t"+q);
        }
        StdOut.println(uf.count+" components");
    }
}
