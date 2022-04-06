package edu.princeton.cs.LeetCode.DP;

//不同路径
public class zjt_62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        //初始化
        for(int i=1;i<n;i++){
            dp[0][i] = 1;
        }
        for(int j=1;j<m;j++){
            dp[j][0] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                //状态转移方程
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }

}
