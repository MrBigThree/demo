package org.example.leetcode.demo;

public class D_0387 {

    public int firstUniqChar(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            array[c - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int loveleetcode = new D_0387().firstUniqChar("loveleetcode");
        System.out.println(loveleetcode);
    }

}
