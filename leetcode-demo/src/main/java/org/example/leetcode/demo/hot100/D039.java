package org.example.leetcode.demo.hot100;

import java.util.*;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/13
 */
public class D039 {

    public static void main(String[] args) {
        List<List<Integer>> lists = new D039().combinationSum(new int[]{2, 3, 5}, 8);
        lists.forEach(list -> {
            System.out.println(list);
        });

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> track, int[] candidates, int target, int begin) {
        int sum = sum(track);
        if (sum > target) {
            return;
        }
        if (sum == target) {
//            if (!contains(result, track)) {
            result.add(new ArrayList<>(track));
//            }
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            track.add(candidates[i]);
            backtrack(result, track, candidates, target, i);
            track.remove(track.size() - 1);
        }

    }

    public int sum(List<Integer> list) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result = result + list.get(i);
        }
        return result;
    }

  
}
