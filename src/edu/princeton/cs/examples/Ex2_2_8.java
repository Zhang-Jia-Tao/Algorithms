package edu.princeton.cs.examples;

import java.util.Arrays;

//证明用归并排序处理一个已经有序的数组所需的比较次数是线性级别的
public class Ex2_2_8 {

    private static Comparable[] aux;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }


    private static  void sort(Comparable[] a,int lo,int hi){
        if(lo >= hi)
            return;
        int mid = lo + (hi-lo)/2;
        sort(a,lo, mid);
        sort(a,mid+1,hi);
        if(!less(a[mid],a[mid+1])){       //只要a[mid] < a[mid+1] 就不用调用merge方法
            merge(a,lo,mid,hi);
        }
    }

    private static void merge(Comparable[] a,int lo,int mid,int hi){
        int i = lo;
        int j = mid+1;
        for(int k=i;k<=hi;k++){
            aux[k] = a[k];
        }

        for(int k=lo;k<=hi;k++){
            if(i>mid)                       a[k] = aux[j++];
            else if(j>hi)                   a[k] = aux[i++];
            else if(less(aux[j],aux[i]))    a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) <= 0;
    }

    public static void main(String[] args) {
        Integer[] ints = {1,2,3,4,8,7,6,5};
        sort(ints);
        System.out.println(Arrays.toString(ints));

    }
}
