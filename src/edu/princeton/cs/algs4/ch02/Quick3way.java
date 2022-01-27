package edu.princeton.cs.algs4.ch02;

import edu.princeton.cs.algs4.StdRandom;

//三向切分的快速排序
public class Quick3way {

    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo)
            return;
        int lt = lo;
        int i = lo+1;
        int gt = hi;
        Comparable v = a[lo];   //切分
        while(i<=gt){
            int cmp = a[i].compareTo(v);
            if(cmp<0){
                exch(a,lt++,i++);
            } else if(cmp>0){
                exch(a,i,gt--);
            } else {
                i++;
            }
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    private static int partation(Comparable[] a,int lo,int hi){

        return 0;
    }

    private static boolean less(Comparable v,Comparable w){ //比较大小 为true时 v < w  为false时 v > w
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a,int i,int j){   //交换元素的位置
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args){
        //测试数据
        Integer[] params = {1,2,2,3,4,5,6,3};
        StdRandom.shuffle(params);
        sort(params);

        for(int i=0;i<params.length;i++){
            System.out.print(params[i]+"\t");
        }
        System.out.println();
    }
}
