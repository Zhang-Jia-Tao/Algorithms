package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

import java.awt.*;

public class Ex1_5_16_WeightedQuickUnion {
    private int[] id;
    private int[] sz;
    private int count;

    private int cost = 0;
    private int total = 0;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int cost) {
        this.total += cost;
    }

    public Ex1_5_16_WeightedQuickUnion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }

    }

    public int count() {
        return count;
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
            cost += 2;
        }
        cost++;
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j)
            return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
            cost += 5;
        } else {
            id[j] = i;
            sz[i] += sz[j];
            cost += 5;
        }
        count--;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        Ex1_5_16_WeightedQuickUnion uf = new Ex1_5_16_WeightedQuickUnion(N);

        StdDraw.setXscale(0,900);
        StdDraw.setYscale(0,1300);
        StdDraw.setPenRadius(0.0005);

        int i=1;
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if(uf.connected(p,q)){
                uf.setTotal(uf.getCost());
                StdDraw.setPenColor(Color.RED);
                StdDraw.point(i,(double) uf.getTotal()/i);
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.point(i,uf.getCost());
                uf.setCost(0);
                i++;
                continue;
            }
            uf.union(p,q);
            uf.setTotal(uf.getCost());
            StdDraw.setPenColor(Color.RED);
            StdDraw.point(i,(double) uf.getTotal()/i);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.point(i,uf.getCost());
            uf.setCost(0);
            i++;
        }
    }

}
