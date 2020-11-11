package org.example.leetcode.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/11/11
 */
public class D_0118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>(numRows);
        if (numRows == 0) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> list0 = new ArrayList<>(1);
        list0.add(1);
        lists.add(list0);
        if (numRows == 1) {
            return lists;
        }
        List<Integer> list1 = new ArrayList<>(2);
        list1.add(1);
        list1.add(1);
        lists.add(list1);
        if (numRows == 2) {
            return lists;
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> listBefore = lists.get(i - 1);
            List<Integer> list = new ArrayList<>(i + 1);
            list.add(1);
            for (int j = 0; j < i - 1; j++) {
                list.add(listBefore.get(j) + listBefore.get(j + 1));
            }
            list.add(1);
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        new D_0118().generate(5);
    }
}
