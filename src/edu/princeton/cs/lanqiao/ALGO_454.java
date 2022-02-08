package edu.princeton.cs.lanqiao;

import java.util.Scanner;

//输出倒等腰三角形
public class ALGO_454 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int num = 0;
        int cou = 1;
        for(int i=N;i>0;i--){
            num = 2*i - 1;
            int temp = cou;     //* 前面的空格数量
            while(temp-- > 0){
                System.out.print(" ");
            }
            while(num-- > 0){
                System.out.print("*");
            }

            System.out.println();
            cou++;
        }
    }
}
