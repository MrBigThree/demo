package org.example.leetcode.demo;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/10/29
 */
public class D_0027 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        new D_0027().removeElement(nums, 3);
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
