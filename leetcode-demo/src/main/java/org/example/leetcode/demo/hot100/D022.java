package org.example.leetcode.demo.hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/5
 */
public class D022 {
    public static void main(String[] args) {
        List<String> list = new D022().generateParenthesis(3);
        System.out.println(list);
    }

    char[] chars = {'(', ')'};

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        backtrack(result, 0, n, new StringBuilder());
        return result;
    }

    private void backtrack(List<String> result, int index, int n, StringBuilder combination) {
        String combinationString = combination.toString();
        if (index == n * 2) {
            if (isValid(combinationString)) {
                result.add(combinationString);
            }
        } else {
            for (int i = 0; i < chars.length; i++) {
                combination.append(chars[i]);
                backtrack(result, index + 1, n, combination);
                combination.deleteCharAt(index);
            }
        }

    }

    /**
     * 判断括号是否有效
     *
     * @param str
     * @return
     */
    private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }

        }
        return stack.isEmpty();
    }

}
