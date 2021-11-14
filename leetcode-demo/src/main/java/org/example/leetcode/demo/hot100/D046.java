package org.example.leetcode.demo.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * //输入：nums = [1,2,3]
 * //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * @author: lvxuhong
 * @date: 2021/11/14
 */
public class D046 {

    public static void main(String[] args) {
        List<List<Integer>> result = new D046().permute(new int[]{1, 2, 3});
        System.out.println(result);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<Integer>(), nums, 0, used);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> track, int[] nums, int index, boolean[] used) {
        if (index == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //关键在于怎么跳过，已经用过的数字
            if (!used[i]) {
                track.add(nums[i]);
                used[i] = true;

                backtrack(result, track, nums, index + 1, used);
                track.remove(track.size() - 1);
                used[i] = false;
            }
        }
    }

}
