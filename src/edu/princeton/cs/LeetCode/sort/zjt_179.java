package edu.princeton.cs.LeetCode.sort;

//最大数
public class zjt_179 {
    public static void main(String[] args) {

    }

    public String largestNumber(int[] nums) {
        String res = "";

        //利用快速排序
        for(int i=0;i<nums.length;i++){

            //若是到了2位甚至多位的数据就开始比较
        }


        return res;
    }

    //获取数值对应的第i位的数据
    private int getFirst(int nums,int i){
        String num = Integer.toString(nums);
        char[] nu = num.toCharArray();
        if(i > nu.length -1){
            return -1;
        }
        return nu[i] - 48;
    }
}
