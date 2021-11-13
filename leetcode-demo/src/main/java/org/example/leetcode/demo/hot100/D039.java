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
        backtrack(result, new ArrayList<>(), candidates, target);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> track, int[] candidates, int target) {
        int sum = sum(track);
        if (sum > target) {
            return;
        }
        if (sum == target) {
            if (!contains(result, track)) {
                result.add(new ArrayList<>(track));
            }
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            track.add(candidates[i]);
            backtrack(result, track, candidates, target);
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

    public boolean contains(List<List<Integer>> result, List<Integer> track) {
        if (result.size() == 0) {
            return false;
        }
        for (List<Integer> list : result) {
            if (equals(list, track)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 两个列表的元素是否相同
     *
     * @param list1
     * @param list2
     * @return
     */
    public boolean equals(List<Integer> list1, List<Integer> list2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer integer : list1) {
            if (map.containsKey(integer)) {
                map.put(integer, map.get(integer) + 1);
            } else {
                map.put(integer, 1);
            }
        }
        for (Integer integer : list2) {
            if (map.containsKey(integer)) {
                map.put(integer, map.get(integer) - 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
