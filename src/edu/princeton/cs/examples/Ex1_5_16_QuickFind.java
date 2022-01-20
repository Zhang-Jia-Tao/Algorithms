package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

import java.awt.*;

//均摊成本的图像
//并未算上初始化数组时的次数
public class Ex1_5_16_QuickFind {
   private int[] id;
   private int count;

   private int cost;        //处理第i个连接时，访问数组的次数
   private int total;       //记录到目前为止数组访问的总次数

   public Ex1_5_16_QuickFind(int N){
       count = N;
       id = new int[N];
       cost = 0;
       total = 0;
       for(int i=0;i<N;i++){
           id[i] = i;
       }
   }

   public int find(int p){
       cost++;
       return id[p];
   }

   public int count(){
       return count;
   }

   public boolean connected(int p,int q){
       cost += 2;
       return find(p) == find(q);
   }

   public void union(int p,int q){
       int pID = find(p);
       int qID = find(q);

       if(pID == qID)
           return;

       for(int i=0;i<id.length;i++){
           cost++;
           if(id[i] == pID) {
               id[i] = qID;
               cost++;
           }
       }
       count--;
   }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total += total;        //累加
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        Ex1_5_16_QuickFind uf = new Ex1_5_16_QuickFind(N);

        StdDraw.setXscale(0,900);
        StdDraw.setYscale(0,2*N);
        StdDraw.setPenRadius(0.0005);
        int i = 1;      //处理的第几个连接
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if(uf.connected(p,q)){
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.point(i,uf.getCost());
                uf.setTotal(uf.getCost());
                StdDraw.setPenColor(Color.RED);
                StdDraw.point(i,(double) uf.getTotal()/i);
                uf.setCost(0);   //设置为0;
                i++;
                continue;
            }
            uf.union(p,q);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.point(i,uf.getCost());
            StdDraw.setPenColor(Color.RED);
            uf.setTotal(uf.getCost());
            StdDraw.point(i,(double) uf.getTotal()/i);
            uf.setCost(0);
            i++;
        }
    }


}
