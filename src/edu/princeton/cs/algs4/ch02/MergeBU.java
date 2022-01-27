package edu.princeton.cs.algs4.ch02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

//自底向上的归并排序
public class MergeBU {

    private static Comparable[] aux = null;

    public static void sort(Comparable[] a){
        int N = a.length;
        aux = new Comparable[N];
        for(int sz=1;sz<N;sz=sz*2){
            for(int lo=0;lo<N-sz;lo += 2*sz){
                merge(a,lo,lo+sz-1,Math.min(lo+2*sz-1,N-1));
            }
        }

    }


    private static void merge(Comparable[] a,int lo,int mid,int hi){
        int i = lo;         //i 为指向左半部分的索引
        int j = mid+1;      //j 为指向右半部分的索引
        for(int k=lo;k<=hi;k++){   //将a[lo..hi] 复制到aux[lo..hi]中
            aux[k] = a[k];
        }

        for(int k=lo;k<=hi;k++){
            if(i>mid){
                a[k] = aux[j++];
            } else if(j>hi){
                a[k] = aux[i++];
            } else if(less(aux[j],aux[i])){
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

    }


    private static boolean less(Comparable v,Comparable w){ //比较大小 为true时 v < w  为false时 v > w
        return v.compareTo(w) < 0;
    }

    public static void main(String[] args) {
        Integer[] ints = {3,2,4,1};
        sort(ints);
        System.out.println(Arrays.toString(ints));

        String[] strings = In.readStrings(args[0]);
        Stopwatch stopwatch = new Stopwatch();
        sort(strings);
        double time = stopwatch.elapsedTime();
        System.out.println(time);
        //System.out.println(Arrays.toString(strings));
    }
}
