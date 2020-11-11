package org.example.leetcode.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/11/11
 */
public class D_0119 {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Collections.EMPTY_LIST;
        }
        List<Integer> list = new ArrayList<>(rowIndex);
        list.add(1);
        if (rowIndex == 1) {
            return list;
        }
        list.add(1);
        if (rowIndex == 2) {
            return list;
        }

        List<Integer> listnew = null;
        for (int i = 2; i < rowIndex; i++) {
            listnew = new ArrayList<>(rowIndex);
            listnew.add(1);
            for (int j = 0; j < i - 1; j++) {
                listnew.add(list.get(j) + list.get(j + 1));
            }
            listnew.add(1);
            list = listnew;
        }
        return listnew;
    }

    public static void main(String[] args) {
        List<Integer> row = new D_0119().getRow(4);
        for (int i = 0; i < row.size(); i++) {
            System.out.println(row.get(i));
        }
    }
}
