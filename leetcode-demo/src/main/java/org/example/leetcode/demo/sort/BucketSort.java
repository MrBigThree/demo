package org.example.leetcode.demo.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/11/10
 */
public class BucketSort {

    private int[] buckets;

    private int[] array;

    public BucketSort(int range, int[] array) {
        this.buckets = new int[range];
        this.array = array;
    }

    public void sort() {
        if (array != null && array.length > 1) {
            for (int i = 0; i < array.length; i++) {
                buckets[array[i]]++;
            }
        }
    }


    public void sortOut() {
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int j = 0; j < buckets[i]; j++) {
                System.out.println(i);
            }

        }
    }

    public static void bucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }

        System.out.println(bucketArr.toString());

    }

    public static void main(String[] args) {
        int[] array = {5, 7, 3, 5, 4, 8, 6, 4, 1, 2};
        Sort sort = new InsertSort();
        sort.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
