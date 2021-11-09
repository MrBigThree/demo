package org.example.leetcode.demo.hot100;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/9
 */
public class D031 {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 1};
        new D031().nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }

    /**
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
     * <p>
     * 解决方式：
     * 先从右边开始遍历，找到一个数字，存在后面的数字大于这个数字，然后交换这两个数字的位置
     * 此时，说明，当前这个数字后面的数字全部为倒序，将后面的数字全部反转过来
     * <p>
     * 如果整个数组是倒序的，那么说明这个已经数最大的了，那么把整个数组反转一遍就好了
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        //先从右往左遍历，找到第一个降序的数字
        int reversedIndex = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                reversedIndex = i - 1;
                break;
            }
        }
        //然后在从当前数字左遍历，找到比当前数字大的最小数字
        if (reversedIndex != -1) {
            int secondIndex = reversedIndex + 1;
            for (int i = reversedIndex + 1; i < nums.length; i++) {
                if (nums[i] > nums[reversedIndex]) {
                    secondIndex = i;
                } else {
                    break;
                }

            }
            //交换两个数字
            nums[reversedIndex] = nums[reversedIndex] ^ nums[secondIndex];
            nums[secondIndex] = nums[reversedIndex] ^ nums[secondIndex];
            nums[reversedIndex] = nums[reversedIndex] ^ nums[secondIndex];
        }
        //然后把当前数字后面的数字顺序反转
        int left = reversedIndex + 1;
        int right = nums.length - 1;
        while (left < right) {
            nums[left] = nums[right] ^ nums[left];
            nums[right] = nums[right] ^ nums[left];
            nums[left] = nums[right] ^ nums[left];
            right--;
            left++;
        }
    }


}
