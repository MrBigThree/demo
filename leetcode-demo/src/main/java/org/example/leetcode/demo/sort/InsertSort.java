package org.example.leetcode.demo.sort;

import java.util.Arrays;

/**
 * @description: //插入排序
 * @author: lvxuhong
 * @date: 2020/11/10
 */
public class InsertSort implements Sort {

    @Override
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            if (j != i - 1) {
                array[j + 1] = temp;
            }
        }
        return array;
    }
}
