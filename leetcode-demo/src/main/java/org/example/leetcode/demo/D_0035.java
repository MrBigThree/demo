package org.example.leetcode.demo;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/10/29
 */
public class D_0035 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        new D_0035().searchInsert(nums,2);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left + 1;

    }
}
