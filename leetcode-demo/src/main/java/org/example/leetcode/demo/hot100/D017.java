package org.example.leetcode.demo.hot100;


import java.util.ArrayList;
import java.util.List;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/3
 */
public class D017 {
    public static void main(String[] args) {
        List<String> list = new D017().letterCombinations("23");
        System.out.println(list);
    }

    char[][] phones = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        backtrack(result, digits, 0, new StringBuffer());
        return result;
    }


    public void backtrack(List<String> result, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            result.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            char[] chars = phones[digit - '0' - 2];
            for (int i = 0; i < chars.length; i++) {
                combination.append(chars[i]);
                backtrack(result, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
