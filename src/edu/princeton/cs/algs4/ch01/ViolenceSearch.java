
package edu.princeton.cs.algs4.ch01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

//暴力查找算法
public class ViolenceSearch {

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty()){
            int val = StdIn.readInt();
            if(rank(val,whitelist) < 0){
                StdOut.println(val);
            }
        }
    }

    public static int rank(int val,int[] a){
        for(int i=0;i<a.length;i++){
            if(val == a[i]){
                return i;
            }
        }
        return -1;
    }
}
