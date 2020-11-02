package org.example.leetcode.demo;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2020/10/30
 */
public class D_0058 {

    public static void main(String[] args) {

        int i = new D_0058().lengthOfLastWord(" ");
        System.out.println(i);
    }

    public int lengthOfLastWord(String s) {
        int start = s.length() - 1;
        int end= s.length() - 1;
        while (start > 0) {
            if (s.charAt(start) == ' ') {
                break;
            }
            start--;
        }
        if (start == 0) {
            return s.length() - start;
        } else {
            return s.length() - 1 - start;
        }

    }
}
