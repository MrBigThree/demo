package org.example.leetcode.demo.hot100;


/**
 * @description: //整数数组 nums 按升序排列，数组中的值 互不相同 。
 * //
 * // 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
 * //k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
 * //,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * //
 * // 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * // 示例 1：
 * //输入：nums = [4,5,6,7,0,1,2], target = 0
 * //输出：4 * //
 * //
 * @author: lvxuhong
 * @date: 2021/11/10
 */
public class D033 {

    public static void main(String[] args) {
        new D033().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
    }

    /**
     * 分析一下，整个数组被分成两部分，这两部分都是有序的，而且旋转点前面的那部分所有的数字都大于后面那部分的数字。
     * <p>
     * 所以二分之后，如果nums[0] < nums[mid] ，说明前半部分是有序的，后半部分可能有序，也可能无序
     * 否则
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //前半部分有序，后半部分可能有序，可能局部有序
            if (nums[left] <= nums[mid]) {
                //如果target在这个有序范围内
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //后半部分有序
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }

}
