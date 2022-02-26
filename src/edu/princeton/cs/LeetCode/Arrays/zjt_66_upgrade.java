package edu.princeton.cs.LeetCode.Arrays;

import java.util.Arrays;

//
public class zjt_66_upgrade {
    public static void main(String[] args) {
        zjt_66_upgrade sol = new zjt_66_upgrade();
        int[] arrays = {1,9,9,9};

        System.out.println(Arrays.toString(sol.plusOne(arrays)));
    }

    public int[] plusOne(int[] digits){
        int length = digits.length;
        for(int i=length-1;i>=0;i--){   //逆序
            if(digits[i] != 9){
                digits[i] = digits[i] + 1;
                //for循环的目的是为了将原先为9的位权小于当前位权的置为零
                for(int j=i+1;j<length;j++){
                    digits[j] = 0;
                }
                return digits;
            }
        }

        //digits中的所有元素均为9
        int[] arrays = new int[digits.length+1];
        arrays[0] = 1;
        return arrays;
    }

}
