package edu.princeton.cs.LeetCode.Arrays;

import edu.princeton.cs.algs4.In;
import sun.jvm.hotspot.jdi.ArrayReferenceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//两个数组的交集
public class zjt_350 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,9,4,8,4};
        zjt_350 sol = new zjt_350();

        System.out.println(Arrays.toString(sol.intersect(nums1,nums2)));

    }

    public int[] intersect(int[] nums1,int[] nums2){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(Integer i:nums1){
            int count = hashMap.getOrDefault(i,0) + 1;
            hashMap.put(i,count);
        }

        for(Integer i:nums2){
            int count = hashMap.getOrDefault(i,0);      //获取指定key对应的value，如果找不到对应的value，则返回defaultValue 0
            if(count > 0){
                arrayList.add(i);
                count--;
                if(count > 0){
                    hashMap.put(i,count);
                } else {
                    hashMap.remove(i);
                }
            }
        }

        int[] res = new int[arrayList.size()];
        int j=0;
        for(Integer i:arrayList){
            res[j++] = i;
        }

        return res;
    }

    //错误版本
    public int[] intersect(int[] nums1, int[] nums2,boolean fa) {

        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> aux = new ArrayList<>();
        for(int i : nums1){
            aux.add(i);
        }
        for(int i : nums2){
            if(aux.contains(i)){
                temp.add(i);
            }
        }
        int[] res = new int[temp.size()];
        int j=0;
        for(Integer i : temp){
            res[j] = i;
            j++;
        }

        return res;
    }
}
