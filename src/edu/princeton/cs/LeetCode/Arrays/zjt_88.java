package edu.princeton.cs.LeetCode.Arrays;

import java.util.Arrays;

//合并两个有序数组
public class zjt_88 {
    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        zjt_88 sol = new zjt_88();
        sol.merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }

    //merge
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }

        if(m == 0){
            for(int l=0;l<n;l++){
                nums1[l] = nums2[l];
            }
            return;
        }
        //以上两个判断是先排除两个特殊条件

        //n>0
        int[] buff = new int[m+n];
        int i = 0;
        int j = 0;      //用来索引nums1
        int k = 0;      //用来索引nums2
        while(true){
            if(nums1[j] < nums2[k]){
                buff[i] = nums1[j];
                j++;
                i++;
                if(j>m-1){      //到达nums1数组的尾部
                    break;
                }
            } else if(nums1[j] > nums2[k]){
                buff[i] = nums2[k];
                k++;
                i++;
                if(k>n-1){      //到达nums2数组的尾部
                    break;
                }
            } else {
                buff[i++] = nums1[j++];
                buff[i++] = nums2[k++];
                if(j>m-1 || k >n-1){
                    break;
                }
            }
        }

        if(j == m && k < n){
            for(int l = k;l<n;l++){
                buff[i] = nums2[l];
                i++;
            }
        } else {
            for(int l=j;l<m;l++){
                buff[i++] = nums1[l];
            }
        }

        for(int l=0;l<m+n;l++){
            nums1[l] = buff[l];
        }
    }
}
