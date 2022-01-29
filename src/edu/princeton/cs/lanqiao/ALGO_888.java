package edu.princeton.cs.lanqiao;


import java.util.Scanner;

public class ALGO_888 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int k = scanner.nextInt();

        if(i<k){
            if(k<j){
                System.out.println(j+"\t"+k+"\t"+i);
            } else {
                if(i>j){
                    System.out.println(k+"\t"+i+"\t"+j);
                } else {
                    System.out.println(k+"\t"+j+"\t"+i);
                }
            }
        } else {    //i>k
            if(k<j){
                if(j>i){
                    System.out.println(j+"\t"+i+"\t"+k);
                } else {
                    System.out.println(j+"\t"+k+"\t"+i);
                }
            } else {    //k>j
                    System.out.println(i+"\t"+k+"\t"+j);
            }
        }


    }
}
