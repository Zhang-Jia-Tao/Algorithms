package edu.princeton.cs.lanqiao;

import java.util.Scanner;

public class 双向排序 {

    public static int[] aux;   //副本

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arrays = new int[n];
        for(int i=0;i<n;i++){ //Initialize
            arrays[i] = i+1;
        }
        aux = new int[n];
        while(scanner.hasNext()){
            int Pi = scanner.nextInt();         //0 降序  1 升序
            int Qi = scanner.nextInt();
            if(Pi == 1){
                sort(arrays,Qi-1,arrays.length-1,1);
            } else {
                sort(arrays,0,Qi-1,0);

            }
        }

        for(int i=0;i<arrays.length;i++){
            System.out.print(arrays[i] + " ");
        }
    }

    public static void sort(int[] arrays,int lo,int hi,int flag){
        if(lo >= hi){
            return;
        }
        int mid = (lo + hi)/2;
        sort(arrays,lo,mid,flag);
        sort(arrays,mid+1,hi,flag);
        merge(arrays,lo,mid,hi,flag);
    }

    public static void sort(int[] arrays,int flag){
        for(int sz = 1; sz<arrays.length;sz = sz + sz){
            for(int lo = 0; lo <arrays.length-sz;lo += 2*sz){
                merge(arrays,lo,lo+sz-1,Math.min(arrays.length-1,lo+2*sz-1),flag);
            }
        }
    }

    public static void merge(int[] arrays,int lo,int mid,int high,int flag){
        int i = lo;
        int j = mid + 1;
        for(int k=lo;k<=high;k++){
            aux[k] = arrays[k];
        }

        if(flag == 1){
            for(int k = lo;k<=high;k++){
                if(i>mid){
                    arrays[k] = aux[j++];
                } else if(j>high){
                    arrays[k] = aux[i++];
                } else if(aux[i] > aux[j]){
                    arrays[k] = aux[j++];
                } else
                    arrays[k] = aux[i++];
            }
        } else {
            for(int k=lo;k<=high;k++){
                if(i>mid) {
                    arrays[k] = aux[j++];
                } else if(j>high){
                    arrays[k] = aux[i++];
                } else if(aux[i]>aux[j]){
                    arrays[k] = aux[i++];
                } else {
                    arrays[k] = aux[j++];
                }
            }
        }
    }





}
