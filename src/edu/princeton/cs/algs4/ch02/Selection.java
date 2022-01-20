package edu.princeton.cs.algs4.ch02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Selection {
    public static void sort(Comparable[] a){
         int min;
        for(int i=0;i<a.length;i++){
            min = i;
            for(int j=i+1;j<a.length;j++){
                if(!less(a[min],a[j])){
                    min = j;
                }
            }
            exch(a,i,min);

        }
    }

    private static boolean less(Comparable v,Comparable w){ //比较大小 为true时 v < w  为false时 v > w
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a,int i,int j){   //交换元素的位置
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for(int i=0;i<a.length;i++){
            StdOut.print(a[i]+"\t");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        for(int i=0;i<a.length;i++){
            if(less(a[i],a[i-1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
