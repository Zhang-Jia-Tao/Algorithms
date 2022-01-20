package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

//不需要交换的插入排序
public class Ex2_1_25 {
    public static void sort(Comparable[] a){
        for(int i=1;i<a.length;i++){
            Comparable temp = a[i];
            int j = i;
            while(j>0 && less(temp,a[j-1])){
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;
        }
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a,int i,int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a){
        for(int i=0;i<a.length;i++){
            StdOut.print(a[i]+"\t");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        String[] a = In.readStrings();
        sort(a);
        show(a);
    }
}
