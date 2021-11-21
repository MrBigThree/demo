package org.example.leetcode.demo.hot100;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/19
 */
public class D070 {

    public static void main(String[] args) {
        int i = new D070().climbStairs(2);
        System.out.println(i);
    }
    /**
     * 动态规划，
     * 最后一个有两种可能，要么走一步，要么走两步
     * f(n) = f(n - 1) + f(n - 2)
     * f(1) = 1
     * f(0) = 1
     *
     *
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
