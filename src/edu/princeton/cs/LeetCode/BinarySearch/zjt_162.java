package edu.princeton.cs.LeetCode.BinarySearch;

//寻找峰值
public class zjt_162 {

    public static void main(String[] args) {
        zjt_162 sol = new zjt_162();
        int[] nums = {1,2,3,1};
        int res = sol.findPeakElement(nums);
        System.out.println(res);

    }

    public int findPeakElement(int[] nums) {

        int lo = 0;
        int hi = nums.length - 1;
        int mid = lo + (hi-lo)/2;
        int left = mid - 1;
        int right = mid + 1;

        int i=0;

        while(left>=0 || right<=hi){
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            } else if(i%2 == 0){
                mid = left;
                left--;
                i++;
            } else {
                mid = right;
                right++;
                i++;
            }
        }

        return -1;

    }
}
