package edu.princeton.cs.lanqiao;

import java.util.Scanner;

//旅游景点
public class ALGO_217 {
    private static int[] ints;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ints = new int[N];
        int i = 0;
        while(scanner.hasNext()){
            ints[i] = scanner.nextInt();
        }

        sort();

        for(int j=0;j<N;j++){
            System.out.print(ints[j]+"\t");
        }
    }

    public static void sort(){  //使用插入排序
        for(int i=0;i<N;i++){
            int min = i;

        }
    }
}
