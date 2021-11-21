package org.example.leetcode.demo.hot100;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/19
 */
public class D063 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int i = new D063().uniquePathsWithObstacles(grid);
        System.out.println(i);
    }

    /**
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 如果 grid[i][j] = 1,那么dp[i][j] = 0
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean hasStone = false;
        for (int i = 1; i < m; i++) {
            if (hasStone) {
                dp[i][0] = 0;
            } else {
                if (obstacleGrid[i][0] == 1) {
                    dp[i][0] = 0;
                    hasStone = true;
                } else {
                    dp[i][0] = 1;
                }
            }
        }

        hasStone = false;
        for (int i = 1; i < n; i++) {
            if (hasStone) {
                dp[0][i] = 0;
            } else {
                if (obstacleGrid[0][i] == 1) {
                    dp[0][i] = 0;
                    hasStone = true;
                } else {
                    dp[0][i] = 1;
                }
            }
        }
        if (obstacleGrid[0][0] == 1) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
