package org.example.leetcode.demo.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/21
 */
public class D056 {

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (right >= interval[0]) {
                //可以合并
                right = Math.max(right, interval[1]);
            } else {
                //不可以合并
                list.add(new int[]{left, right});
                left = interval[0];
                right = interval[1];
            }
            if (i == intervals.length - 1) {
                list.add(new int[]{left, right});
            }
        }
        return list.toArray(new int[0][]);
    }
}
