package edu.princeton.cs.LeetCode.Arrays;


import edu.princeton.cs.algs4.util.Stopwatch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class zjt_217_upgrade {
    public static void main(String[] args) {
        int[] array = new int[10000];
        for(int i=0;i<9999;i++){
            array[i] = i;
        }
        array[9999] = 1;
        Stopwatch stopwatch = new Stopwatch();
        zjt_217_upgrade sol = new zjt_217_upgrade();
        double v = stopwatch.elapsedTime();
        System.out.println(sol.containsDuplicate(array));
        System.out.println("times : "+v);
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;

    }
}
