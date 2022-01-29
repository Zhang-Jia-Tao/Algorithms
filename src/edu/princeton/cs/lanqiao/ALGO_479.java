package edu.princeton.cs.lanqiao;

import java.util.Scanner;

//整数排序          80分  不知道错哪了
public class ALGO_479 {
    private static int[] ints;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ints = new int[N];
        int i=0;
        while(scanner.hasNext()){
            ints[i] = scanner.nextInt();
            i++;
        }

        sort();

        for(int j=0;j<ints.length;j++){
            System.out.print(ints[j]+"\t");
        }



    }

    public static void sort(){
        for(int i=0;i<ints.length;i++){
            int min = i;
            for(int j=i+1;j<ints.length;j++){
                if(ints[min] > ints[j]){
                    min = j;
                }
            }
            int temp = ints[i];
            ints[i] = ints[min];
            ints[min] = temp;
        }
    }
}
