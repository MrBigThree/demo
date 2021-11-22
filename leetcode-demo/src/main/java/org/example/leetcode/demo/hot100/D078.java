package org.example.leetcode.demo.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/22
 */
public class D078 {

    public static void main(String[] args) {
        List<List<Integer>> subsets = new D078().subsets(new int[]{1, 2, 3, 4, 5});
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            backtrack(result, i, 0, list, nums);
        }
        return result;
    }

    public void backtrack(List<List<Integer>> result, int size, int index, List<Integer> list, int[] nums) {
        if (index == size) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(result, size, i + 1, list, nums);
            list.remove(list.size() - 1);
        }
    }

}
