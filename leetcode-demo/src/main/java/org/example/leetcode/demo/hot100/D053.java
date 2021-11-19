package org.example.leetcode.demo.hot100;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/18
 */
public class D053 {

    public static void main(String[] args) {
        int i = new D053().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }

    /**
     * f(i) 表示长度从0到i的数组的最大子序列和，
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        //表示以第i个数字结尾的最大子序列和，
        //如果dp[i - 1] > 0,那么dp[i]就是dp[i - 1] + nums[i]
        //如果dp[i - 1] < 0,那么dp[i]就是nums[i]
        int result = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current;
            if (pre < 0) {
                current = nums[i];
            } else {
                current = pre + nums[i];
            }
            pre = current;
            result = Math.max(result, current);
        }
        return result;
    }
}
