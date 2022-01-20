package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

import java.awt.*;

//
public class Ex1_5_16_QuickUnion {
    private int[] id;
    private int count;

    int cost;
    int total;

    public Ex1_5_16_QuickUnion(int N){
        count = N;
        id = new int[N];
        cost = 0;
        total = 0;
        for(int i=0;i<N;i++){
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public int find(int p){
         while(p != id[p]) {
             p = id[p];
             cost += 2;
         }
         cost++;   //当while 循环判断为false时 ，判断时访问数组的加1
        return p;
    }

    public boolean connected(int p,int q){
        return find(p) == find(q);
    }

    public void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return;

        id[pRoot] = qRoot;
        count--;
    }

    public void setTotal(int cost){
        this.total += cost;
    }

    public int getTotal(){
        return total;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        Ex1_5_16_QuickUnion uf = new Ex1_5_16_QuickUnion(N);

        StdDraw.setXscale(0,900);
        StdDraw.setYscale(0,100);
        StdDraw.setPenRadius(0.00005);

        int i = 1;
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if(uf.connected(p,q)){
                uf.setTotal(uf.cost);
                StdDraw.setPenColor(Color.RED);
                StdDraw.point(i,(double) uf.getTotal()/i);
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.point(i,uf.cost);
                uf.cost = 0;
                i++;
                continue;
            }
            uf.union(p,q);
            uf.setTotal(uf.cost);
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(i,(double) uf.getTotal()/i);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.point(i,uf.cost);
            uf.cost = 0;
            i++;
        }
    }
}
