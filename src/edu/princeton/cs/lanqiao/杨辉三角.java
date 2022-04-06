package edu.princeton.cs.lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class 杨辉三角 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arrays = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(arrays[i],1);
        }
        for(int i=2;i<n;i++){
            int j=1;
            while(j <= i-1){
                arrays[i][j] = arrays[i-1][j] + arrays[i-1][j-1];
                if(arrays[i][j] == n){
                    int sum = ((i)*(i) + (i))/2 + j + 1;
                    System.out.println(sum);
                    return;
                }
                j++;
            }
        }
    }
}
