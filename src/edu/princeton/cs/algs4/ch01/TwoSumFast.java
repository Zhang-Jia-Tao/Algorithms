package edu.princeton.cs.algs4.ch01;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class TwoSumFast {
    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }

    public static int count(int[] a){
        Arrays.sort(a);    //先将数组进行排序
        int cnt = 0;
        for(int i=0;i<a.length;i++){
            if(BinarySearch.rank(-a[i],a)>i){
                cnt++;
            }
        }
        return cnt;
    }
}
