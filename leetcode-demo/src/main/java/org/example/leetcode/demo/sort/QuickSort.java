package org.example.leetcode.demo.sort;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/3
 */
public class QuickSort implements Sort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {1, 13, 123, 3, -2, 3, 6100};
        //int[] array = {3, 3, 13, 6};
        int[] sort = quickSort.sort(array);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i]);
        }
    }

    @Override
    public int[] sort(int[] array) {
        int begin = 0;
        int end = array.length - 1;
        sort(array, begin, end);
        return array;
    }

    private void sort(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        if (end - begin == 1 && array[begin] > array[end]) {
            int temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
        }
        int temp = array[begin];
        int left = begin + 1;
        int right = end;
        while (left < right) {
            while (array[left] < temp && left < right) {
                left++;
            }
            while (array[right] > temp && left < right) {
                right--;
            }
            if (left < right) {
                int temp2 = array[right];
                array[right] = array[left];
                array[left] = temp2;
            }
        }
        array[begin] = array[left - 1];
        array[left - 1] = temp;

        sort(array, begin, left - 2);
        sort(array, left, end);
    }
}
