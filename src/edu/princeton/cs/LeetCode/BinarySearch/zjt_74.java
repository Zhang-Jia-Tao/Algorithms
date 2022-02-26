package edu.princeton.cs.LeetCode.BinarySearch;

//探索二维矩阵
public class zjt_74 {
    public static void main(String[] args) {
        zjt_74 sol = new zjt_74();
        int[][] arrays = {{1}};
        System.out.println(sol.searchMatrix(arrays,2));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;      //共有几行
        int n = matrix[0].length;   //每行有多少列  或  每行有多少个元素


        //先将其每行的最后一个元素保存在一个一维数组中
        int[] aux = new int[m];
        for(int i=0;i<m;i++){
            aux[i] = matrix[i][n-1];
        }

        //利用二分查找，判断target所在的行
        int lo = 0;
        int hi = m-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(target < aux[mid]){
                hi = mid - 1;
            } else if (target > aux[mid]){
                lo = mid + 1;
            } else {    //target == aux[mid]
                return true;
            }
        }

        if(lo >= m){            //防止访问数组时溢出
            return false;
        }

        for(int i=0;i<matrix[lo].length;i++){
            if(target == matrix[lo][i]){
                return true;
            }
        }
        return false;
    }
}
