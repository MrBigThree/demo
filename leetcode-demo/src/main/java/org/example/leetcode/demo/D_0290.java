package org.example.leetcode.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/11/12
 */
public class D_0290 {

    public boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        if (array.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            Character character = pattern.charAt(i);
            String str1 = map.get(character);
            if (str1 != null) {
                if (!str1.equals(str)) {
                    return false;
                }
            } else {
                map.put(character, str);
            }
        }

        //重复一次
        Map<String, Character> map1 = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Character character = pattern.charAt(i);
            String str = array[i];
            Character character1 = map1.get(str);
            if (character1 != null && !character1.equals(character)) {
                return false;
            } else {
                map1.put(str, character);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new D_0290().wordPattern("abba", "dog cat cat dog");
    }
}
