package org.example.leetcode.demo.hot100;

import java.util.*;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/18
 */
public class D049 {

    public static void main(String[] args) {
        Integer integer = new Integer(1000);
        Integer integer1 = new Integer(1000);

        System.out.println(integer1 == integer);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> listMap = new HashMap<>();
        for (String str : strs) {
            //重新排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (listMap.containsKey(sortedStr)) {
                List<String> list = listMap.get(sortedStr);
                list.add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                listMap.put(sortedStr, list);
            }
        }
        Set<String> keySet = listMap.keySet();
        ArrayList<List<String>> result = new ArrayList<>(keySet.size());
        for (String key : keySet) {
            result.add(listMap.get(key));
        }
        return result;
    }
}
