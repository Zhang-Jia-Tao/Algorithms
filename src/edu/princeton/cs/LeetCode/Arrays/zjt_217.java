package edu.princeton.cs.LeetCode.Arrays;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

//存在重复元素
//我想利用二分查找
public class zjt_217 {
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        zjt_217 solution = new zjt_217();
        int[] array = {1,2,3,4,5,7,8,9,10,2};
        double v = stopwatch.elapsedTime();
        System.out.println((solution.containsDuplicate(array)));
        System.out.println("times : "+v);
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i == nums.length - 1){       //防止访问数组溢出
                return false;
            }
            if(nums[i+1] != nums[i]){
                continue;
            } else {
                return true;
            }
        }
        return false;
    }

}
