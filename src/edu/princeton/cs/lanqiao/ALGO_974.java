package edu.princeton.cs.lanqiao;

import java.util.Scanner;

//数组求和
public class ALGO_974 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a1 = new int[n];
        int[] a2 = new int[n];
        int[] result = new int[n];

        for(int i=0;i<n;i++){
            a1[i] = scanner.nextInt();
        }

        for(int i=0;i<n;i++){
            a2[i] = scanner.nextInt();
        }

        Add(n,a1,a2,result);

    }

    public static void Add(int n,int[] a1,int[] a2,int[] result){
        for(int i=0;i<n;i++){
            result[i] = a1[i] + a2[i];
            System.out.print(result[i]+" ");
        }


    }
}
