package org.example.leetcode.demo.hot100;

import java.util.HashSet;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/10/30
 */
public class D003 {

    public static void main(String[] args) {
        int res = lengthOfLongestSubstring("a");
        System.out.println(res);


    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet set = new HashSet<Character>();
        int res = 0;
        int fastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (fastIndex < s.length() && !set.contains(s.charAt(fastIndex))) {
                set.add(s.charAt(fastIndex));
                fastIndex = fastIndex + 1;
            }
            res = Math.max(res, fastIndex - i);
        }
        return res;
    }
}
