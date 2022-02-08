package edu.princeton.cs.lanqiao;

import java.util.Scanner;

//找数2 ---> 利用二分查找
public class ALGO_542 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arrays = new int[N];

        for(int i=0;i<N;i++){
            arrays[i] = scanner.nextInt();
        }

        int X = scanner.nextInt();

        //利用二分查找 查找X

        int index = BinarySearch(arrays,X,0,N-1);

        System.out.println(index+1);

    }

    private static int BinarySearch(int[] arrays,int X,int lo,int hi){
        int mid = lo + (hi-lo)/2;
        while(lo <= hi){
            if(X > arrays[mid]){
                 return BinarySearch(arrays,X,mid+1,hi);
            } else if(X < arrays[mid]){
                 return BinarySearch(arrays,X,lo,mid-1);
            } else {
                return mid;
            }
        }
        return lo;
    }

}
