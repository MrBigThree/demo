package org.example.leetcode.demo.hot100;


/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/10/31
 */
public class D004 {

    public static void main(String[] args) {
        System.out.println(5 / 2);
//        int[] nums1 = {1, 2};
//        int[] nums2 = {3, 4};
//        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
//        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //先归并排序
        int[] nums = new int[nums1.length + nums2.length];
        int i = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                nums[i] = nums1[index1];
                index1++;
            } else {
                nums[i] = nums2[index2];
                index2++;
            }
            i++;
        }
        if (index1 < nums1.length) {
            for (int j = index1; j < nums1.length; j++, i++) {
                nums[i] = nums1[j];
            }
        }
        if (index2 < nums2.length) {
            for (int j = index2; j < nums2.length; j++, i++) {
                nums[i] = nums2[j];
            }
        }

        for (int i1 = 0; i1 < nums.length; i1++) {
            System.out.println(nums[i1]);
        }
        //然后取出中位数
        int sumLength = nums.length;
        if (sumLength % 2 == 0) {
            return (nums[sumLength / 2] + nums[(sumLength / 2) - 1]) / 2.0;
        } else {
            return nums[sumLength / 2];
        }
        //如果是长度为偶数，则中位数是 (num[n/2] + num[n/2 -1] )/2

        //如果是奇数，中位数是num[n/2]
    }

    /**
     * 使用二分法
     * O(log(min(m,n)))
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays1(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;

    }

}
