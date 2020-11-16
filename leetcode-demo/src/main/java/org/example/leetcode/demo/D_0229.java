package org.example.leetcode.demo;

import java.util.ArrayList;
import java.util.List;

public class D_0229 {

    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        int num1 = nums[0], num2 = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (num1 == nums[i]) {
                count1++;
            } else if (num2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num1 == nums[i]) {
                count1++;
            } else if (num2 == nums[i]) {
                count2++;
            }
        }
        List<Integer> list = new ArrayList<>();
        if (count1 > nums.length / 3) {
            list.add(num1);
        }
        if (count2 > nums.length / 3) {
            list.add(num2);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 2};
        List<Integer> list = new D_0229().majorityElement(nums);
        for (Integer i : list
        ) {
            System.out.println(i);
        }
    }
}
