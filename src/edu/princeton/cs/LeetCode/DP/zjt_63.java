package edu.princeton.cs.LeetCode.DP;

import java.util.Arrays;

//不同的路径ii
public class zjt_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 1 && obstacleGrid[0].length == 1 && obstacleGrid[0][0] == 0){
            return 1;
        }
        //明确dp数组的以及dp[i][j]的含义
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        //初始化dp数组
        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[0].length;j++){
                dp[i][j] = (obstacleGrid[i][j] == 1) ? 0 : -1;
            }
        }
        for(int i=0;i<obstacleGrid.length;i++){
           if(dp[0][i] == 0){
               for(int j=i+1;j<obstacleGrid.length;j++){
                   dp[0][j] = 0;
               }
               break;
           }
        }
        for(int i=0;i<obstacleGrid[0].length;i++){
            if(dp[i][0] == 0){
                for(int j=i+1;j<obstacleGrid[0].length;j++){
                    dp[j][0] = 0;
                }
                break;
            }
        }

        for(int i=1;i<obstacleGrid.length;i++){
            for(int j=1;j<obstacleGrid[i].length;j++){
                if(dp[i][j] == 0)
                    continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

}
