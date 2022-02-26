package edu.princeton.cs.LeetCode.Arrays;

import java.util.Arrays;

//加1
public class zjt_66 {
    public static void main(String[] args) {
        zjt_66 sol = new zjt_66();
        int[] arr = {9,9,9};
        int[] arrs = sol.plusOne(arr);
        System.out.println(Arrays.toString(arrs));
    }

    public int[] plusOne(int[] digits) {
        int hi = digits.length;
        return plusOne(digits,hi);
    }

    private int[] plusOne(int[] digits,int hi){
        hi--;
        if(hi < 0){
            //调用新的方法 去增加数组的长度
            return plusOnes(digits);
        }
            if (digits[hi] >= 0 && digits[hi] <= 8) {
                digits[hi] = digits[hi] + 1;
            } else {
                digits[hi] = 0;
                plusOne(digits, hi);
            }
            //递归调用 不大好处理
            return digits;
    }

    private int[] plusOnes(int[] digits){
        int[] digitss = new int[digits.length+1];
        digitss[0] = 1;
        return  digitss;
    }

}
