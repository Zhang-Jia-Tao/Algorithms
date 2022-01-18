package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Ex1_4_15_TwoSumFaster {

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }

    public static int count(int[] a){
        Arrays.sort(a);
        int cnt = 0;
        for(int i=0,j=a.length-1;i<j;){
            if(a[i]+a[j] < 0){
                i++;
            } else if(a[i]+a[j]>0){
                j--;
            } else {
                i++;
                j--;
                cnt++;
            }
        }
        return cnt;
    }
}
