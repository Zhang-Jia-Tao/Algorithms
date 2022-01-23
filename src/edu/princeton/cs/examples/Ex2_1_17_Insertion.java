package edu.princeton.cs.examples;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.util.RandomColor;

import java.awt.*;

public class Ex2_1_17_Insertion {
    public static void main(String[] args) {
        System.out.print("请输入数组的大小：");
        int no = StdIn.readInt();
        Integer[] ints = new Integer[no];

        //初始化-随机
        for(int i=0;i<ints.length;i++){         //根据根据需要修改数组的数据类型
            ints[i] = StdRandom.uniform(no);
        }

        //初始化图形化界面
        StdDraw.setXscale(0,2*no);
        StdDraw.setYscale(0,2*no);
        //StdDraw.setPenRadius(0.005);        //可要可不要
        StdDraw.setPenColor(StdDraw.BLACK);

        sort(ints);

        for(int i=0;i<ints.length;i++){
            double x = 2*i;
            double y = ints[i]/2.0;
            double rw = 1;
            double rh = ints[i]/2.0;
            StdDraw.filledRectangle(x,y,rw,rh);
            StdDraw.setPenColor(new Color(RandomColor.randomColor()));
        }

    }

    public static void sort(Comparable[] a){
        for(int i=1;i<a.length;i++){
            Comparable temp = a[i];
            int j = i;
            while(j>0 && less(temp,a[j-1])){
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;

            draw(a);
        }
    }

    public static void draw(Comparable[] a){
        for(int i=0;i<a.length;i++){
            double x = 2*i;
            Integer y = (Integer) a[i]/2;
            double rw = 1;
            Integer rh = (Integer) a[i]/2;
            StdDraw.filledRectangle(x,y,rw,rh);
            StdDraw.setPenColor(new Color(RandomColor.randomColor()));
        }
        StdDraw.show(1000);
        StdDraw.clear();
    }

    private static boolean less(Comparable v,Comparable w){ //比较大小 为true时 v < w  为false时 v > w
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a,int i,int j){   //交换元素的位置
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for(int i=0;i<a.length;i++){
            StdOut.print(a[i]+"\t");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        for(int i=0;i<a.length;i++){
            if(less(a[i],a[i-1]))
                return false;
        }
        return true;
    }
}
