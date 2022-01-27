package edu.princeton.cs.algs4.ch02;

import edu.princeton.cs.algs4.StdRandom;

//快速排序
public class Quick {
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        if(lo>=hi)
            return;
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);

    }

    private static int partition(Comparable[] a,int lo,int hi){
        int i = lo;
        int j = hi+1;
        Comparable v = a[lo];
        while(true){
            while(less(a[++i],v)){
                if(i == hi)
                    break;
            }
            while(less(v,a[--j])){
                if(j == lo){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }

    private static boolean less(Comparable v,Comparable w){ //比较大小 为true时 v < w  为false时 v > w
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a,int i,int j){   //交换元素的位置
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = {1,2,3,3,4,5,6,7,8,9,10,11,12,13,15,19};
        sort(a);
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+"\t");
        }
    }

}
