package edu.princeton.cs.algs4.ch01;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingTest {
    public static double timeTrial(int N){
        //为处理N个随机的六位整数的ThreeSum.count()计时
        int Max = 1000000;
        int[] a = new int[N];
        for(int i=0;i<N;i++){
            a[i] = StdRandom.uniform(-Max,Max);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapseTime();
    }

    public static void main(String[] args) {
        //打印运行时间的表格
        for(int N = 250;true;N += N){
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n",N,time);
        }

    }
}
