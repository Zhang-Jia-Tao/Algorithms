package edu.princeton.cs.examples;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ch01.BinarySearch;
import edu.princeton.cs.algs4.util.Flag;
import edu.princeton.cs.algs4.util.addOverFlow;

import java.util.Arrays;

public class Ex1_4_2 {

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));

    }

    public static int count(int[] a){
        Arrays.sort(a);
        int cnt = 0;
        int res = 0;
        Flag flag = new Flag();
        flag.setFlag(false);
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
               res = addOverFlow.addExact(a[i],a[j],flag);   //判断是否溢出的同时将a[i] 与 a[j] 相加
               if(flag.isFlag()){   //如果溢出     //2147483647  和  2  来测试是否溢出
                   System.out.println("可以加断点判断");
                   flag.setFlag(false);
                   continue;
               }
               if(BinarySearch.rank(-res,a) > j){
                   cnt++;
               }
            }
        }
        return cnt;
    }
}



