package edu.princeton.cs.LeetCode.BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//两个数组的交集
//利用的是二分查找
// 将nums1中的每个元素进行遍历，利用二分查找与nums2中的值进行匹配
public class zjt_349 {
    public static void main(String[] args) {
        zjt_349 ol = new zjt_349();
        int[] a1 = {1,2,2,1};
        int[] a2 = {2,2,3};
        int[] temp = ol.intersection(a1,a2);
        System.out.print(Arrays.toString(temp));
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> set = new HashSet<>();
        int index = 0;

        for(int i=0;i<nums2.length;i++){
            int lo = 0;
            int hi = nums1.length -1;
            while(lo <= hi){
                int mid = lo + (hi - lo)/2;
                if(nums2[i] < nums1[mid]) {
                    hi = mid - 1;
                }else if(nums2[i] > nums1[mid]){
                    lo = mid + 1;
                } else { //相等的情况
                    if(index == 0){
                        //results[index] = nums2[i];
                        set.add(nums2[i]);
                        index++;
                        break;
                    } else {
                        //results[index] = nums2[i];
                        set.add(nums2[i]);
                        index++;
                        break;
                    }
                }
            }
        }
        int[] res = new int[set.size()];
        int i=0;
        for(int val:set){
            res[i] = val;
            i++;
        }
        return res;
    }
}
