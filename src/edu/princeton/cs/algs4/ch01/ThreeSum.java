package edu.princeton.cs.algs4.ch01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

//统计所有和为0的三整数元组的数量
public class ThreeSum {
    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        Stopwatch stopwatch = new Stopwatch();
        StdOut.println(count(a));
        System.out.println("该程序总耗时约；"+stopwatch.elapseTime());
    }

    public static int count(int[] a){
        int N = a.length;
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                for(int k=j+1;k<N;k++){
                    if(a[i]+a[j]+a[k] == 0){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
