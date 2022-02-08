package edu.princeton.cs.lanqiao;


import java.util.Scanner;

//印章问题
public class ALGO_1007 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        double p = (double) 1/n;        //概率

        if(n > m){      //不可能凑齐
            p = 0.0000;
            System.out.printf("%.4f",p);
            return;
        }

        //n < m
        double result;
        


    }
}
