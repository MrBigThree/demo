package org.example.leetcode.demo.hot100;

import java.util.Optional;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/2
 */
public class D011 {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = -1;
        while (left < right) {
            maxArea = Math.max(Math.min(height[left], height[right]) * (right - left), maxArea);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }

        }
        return maxArea;
    }
}
