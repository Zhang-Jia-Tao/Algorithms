package edu.princeton.cs.algs4.ch02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.ch01.Stopwatch;
import edu.princeton.cs.examples.Ex2_1_25;

public class SortCompare {
    public static double time(String alg,Double[] a){
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion"))
            Insertion.sort(a);
        if(alg.equals("Selection"))
            Selection.sort(a);
        if(alg.equals("Ex2_1_25"))   //基本上t2/t1 平均值维持在0.7
            Ex2_1_25.sort(a);
        return timer.elapseTime();
    }

    public static double time(String alg,Integer[] a){
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion"))
            Insertion.sort(a);
        if(alg.equals("Selection"))
            Selection.sort(a);
        return timer.elapseTime();
    }

    public static double timeRandonmInput(String alg,int N,int T){
        //使用算法alg将T个长度为N的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for(int i=0;i<T;i++){
            for(int j=0;j<N;j++){
                a[j] = StdRandom.uniform();
            }
            total +=time(alg,a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);      //  N为数组的长度
        int T = Integer.parseInt(args[3]);      //  T为重复次数

        double t1 = timeRandonmInput(alg1,N,T);
        double t2 = timeRandonmInput(alg2,N,T);

        StdOut.printf("For %d random Doubles\n      %s is ",N,alg1);
        StdOut.printf("%.1f times faster than %s\n",t2/t1,alg2);
    }
}
