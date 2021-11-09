package org.example.leetcode.demo.hot100;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/11/6
 */
public class D326 {

    public static void main(String[] args) {
        System.out.println(new D326().isPowerOfThree(27));
    }
    public boolean isPowerOfThree(int n) {
        while (n > 1) {
            if (n % 3 == 0) {
                n = n /3;
            }else {
                return false;
            }
        }
        return n == 1;
    }
}
