package edu.princeton.cs.LeetCode.BinarySearch;

import java.util.Scanner;

//x的平方根
public class zjt_69 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if(x == 0){
            System.out.print(0);
        }
        if(x == 1){
            System.out.print(1);
        }
        zjt_69 zjt_69 = new zjt_69();
        int res = zjt_69.mySqrt(x,2);
        System.out.println(res);

        int res1 = zjt_69.mySqrt(x);
        System.out.print(res1);
    }

    public int mySqrt(int x,int j){
        if(j*j < x){
            return mySqrt(x,j+1);
        } else if(j*j > x){
            return j-1;
        } else {
            return j;
        }

    }

    public int mySqrt(int x){
        int res = -1;
        int lo = 0;
        int hi = x;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if((long)mid * mid <= x){
                res = mid;
                lo = mid +1;
            } else {
                hi = mid -1;
            }
        }

        return res;
    }
}
