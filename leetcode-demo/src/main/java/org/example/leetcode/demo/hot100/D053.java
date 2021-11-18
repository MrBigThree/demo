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

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
