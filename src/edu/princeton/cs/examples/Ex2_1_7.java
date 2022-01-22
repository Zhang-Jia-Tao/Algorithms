package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ch02.SortCompare;

public class Ex2_1_7 {
    public static void main(String[] args) {
        Integer[] a1 = new Integer[1000];
        Integer[] a2 = new Integer[1000];

        for(int i=999;i>=0;i--){
            a1[i] = i;
            a2[i] = i;
        }

        double spendTime01 = SortCompare.time("Insertion",a1);
        double spendTime02 = SortCompare.time("Selection",a2);

        StdOut.println("Insertion way spend "+spendTime01);
        StdOut.println("Selection way spend "+spendTime02);

        //对于逆序数组，插入排序更快

    }
}
