package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.ch02.SortCompare;

//主键都相同时，选择排序与插入排序谁更快
public class Ex2_1_6 {
    public static void main(String[] args) {
        //两个数组均初始化，使其主键均相等
        Double[] a1 = new Double[1000];
        Double[] a2 = new Double[1000];
        for(int i=0;i<1000;i++){
            a1[i] = 10.0;
            a2[i] = 10.0;
        }

        //调用SortCompare
        double spendTime01 = SortCompare.time("Insertion",a1);
        double spendTime02 = SortCompare.time("Selection",a2);

        StdOut.println("Insertion way spend "+spendTime01);
        StdOut.println("Selection way spend "+spendTime02);

        //结论：在主键均相同的数据集合中，插入排序花费的时间更短
    }
}
