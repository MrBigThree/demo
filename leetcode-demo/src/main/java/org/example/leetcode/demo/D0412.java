package org.example.leetcode.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: //
 * <p>
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * // answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * // answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * // answer[i] == i 如果上述条件全不满足。
 * @author: lvxuhong
 * @date: 2021/11/14
 */
public class D0412 {

    public static void main(String[] args) {
        List<String> list = new D0412().fizzBuzz(3);
        System.out.println(list);
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        int m = 1;
        int k = 1;
        for (int i = 1; i <= n; i++) {
            if (m != 3 && k != 5) {
                list.add(String.valueOf(i));
                m++;
                k++;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                if (m == 3) {
                    //3的倍数
                    stringBuilder.append("Fizz");
                    m = 1;
                }else {
                    m++;
                }
                if (k == 5) {
                    stringBuilder.append("Buzz");
                    k = 1;
                }else {
                    k++;
                }
                list.add(stringBuilder.toString());
            }
        }
        return list;
    }
}
