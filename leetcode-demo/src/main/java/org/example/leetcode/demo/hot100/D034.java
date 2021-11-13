package org.example.leetcode.demo.hot100;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/12
 */
public class D034 {

    public static void main(String[] args) {
        int[] result = new D034().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        for (int i : result) {
            System.out.print(i);
            System.out.print(",");
        }

    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int start = searchTarget(nums, target, 1);
        int end = searchTarget(nums, target, 2);
        return new int[]{start, end};
    }


    /**
     * @param nums
     * @param target
     * @param type   1 ,寻找开始节点，2寻找结束节点
     * @return
     */
    public int searchTarget(int[] nums, int target, int type) {
        int result = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == nums[middle]) {
                result = middle;
                if (type == 1) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }

        }
        return result;
    }


}
