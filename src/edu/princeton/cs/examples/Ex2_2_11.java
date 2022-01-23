package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MergeX;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ch02.Insertion;

import java.util.Arrays;

//证明用归并排序处理一个已经有序的数组所需的比较次数是线性级别的
public class Ex2_2_11 {

    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1,1);
    }


    private static  void sort(Comparable[] a,int lo,int hi){
        if(hi-lo <= 500) {            //加快小数组的排序速度
            Insertion.sort(a);
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort(a,lo, mid);
        sort(a,mid+1,hi);
        if(!less(a[mid],a[mid+1])){       //只要a[mid] < a[mid+1] 就不用调用merge方法
            merge(a,lo,mid,hi);
        }
    }

    private static void sort(Comparable[] a,int lo,int hi,int flag){
        if(hi-lo<=30){
            edu.princeton.cs.algs4.Insertion.sort(a);
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi,1);
        for(int i=lo;i<=hi;i++){
            a[i] = aux[i];
        }

    }

    //未改进版本
    private static void merge(Comparable[] a,int lo,int mid,int hi){
        int i = lo;
        int j = mid+1;
        for(int k=i;k<=hi;k++){
            aux[k] = a[k];
        }

        for(int k=lo;k<=hi;k++){
            if(i>mid)                       a[k] = aux[j++];
            else if(j>hi)                   a[k] = aux[i++];
            else if(less(aux[j],aux[i]))    a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
    }

    //改进版
    public static void merge(Comparable[] a,int lo,int mid,int hi,int flag){
        int i=lo;
        int j=mid+1;
        for(int k=lo;k<=hi;k++){
            if(i>mid){
                aux[k] = a[j++];
            } else if(j>hi){
                aux[k] = a[i++];
            } else if(less(a[j],a[i])){
                aux[k] = a[j++];
            } else {
                aux[k] = a[i++];
            }
        }
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) <= 0;
    }

    public static void main(String[] args) {
        Integer[] ints = {1,2,3,4,8,7,6,5};
        sort(ints);
        System.out.println(Arrays.toString(ints));

        String[] strs = In.readStrings(args[0]);
        Stopwatch stopwatch = new Stopwatch();
        sort(strs);
        double time = stopwatch.elapsedTime();
        System.out.println(Arrays.toString(strs));
        System.out.println(time);

    }

}
