package org.example.leetcode.demo.hot100;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/22
 */
public class D075 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        new D075().sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void sortColors(int[] nums) {
        //排序，不过只有三个数字
//        int slow = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                int temp = nums[slow];
//                nums[slow] = nums[i];
//                nums[i] = temp;
//                slow++;
//            }
//        }
//        for (int i = slow; i < nums.length; i++) {
//            if (nums[i] == 1) {
//                int temp = nums[slow];
//                nums[slow] = nums[i];
//                nums[i] = temp;
//                slow++;
//            }
//        }

        /**
         * 头尾各放一个指针
         */
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i < nums.length && i <= right) {
            if (nums[i] == 0) {
                if (i == left) {
                    i++;
                    continue;
                }
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            } else if (nums[i] == 2) {
                if (i == right) {
                    i++;
                    continue;
                }
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }
            if (nums[i] != 0 && nums[i] != 2) {
                i++;
            }
        }

    }
}
