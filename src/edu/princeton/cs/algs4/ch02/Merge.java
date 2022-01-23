package edu.princeton.cs.algs4.ch02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.examples.Ex2_2_11;
import javafx.scene.paint.Stop;

import java.util.Arrays;

//自顶向下的归并排序
public class Merge {

    private static Comparable[] aux = null;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        if(hi <= lo)
            return;
        int mid = lo + (hi-lo)/2;
        sort(a,lo,mid);         //将左半边排序
        sort(a,mid+1,hi);   //将右半边排序
        merge(a,lo,mid,hi);
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
