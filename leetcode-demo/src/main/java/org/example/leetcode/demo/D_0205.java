package org.example.leetcode.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/11/12
 */
public class D_0205 {

    public boolean isIsomorphic(String s, String t) {
        return fun(s, t) && fun(t, s);

    }

    public boolean fun(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character oChar = map.get(sChar);
            Character tChar = t.charAt(i);
            if (oChar == null) {
                map.put(sChar, tChar);
            } else {
                if (tChar != oChar) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        boolean isomorphic = new D_0205().isIsomorphic("ab", "aa");

        System.out.println(isomorphic);
    }


}
