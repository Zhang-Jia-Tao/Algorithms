package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ch01.BinarySearch;

import java.util.Arrays;

public class Ex1_4_14 {

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }

    public static int count(int[] a){
        Arrays.sort(a);
        int cnt = 0;
        for(int i=0;i<a.length-2;i++){
            for(int j=i+1;j<a.length-1;j++){
                for(int k=j+1;k<a.length;k++){
                    if(BinarySearch.rank(-a[i]-a[j]-a[k],a) > k){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
