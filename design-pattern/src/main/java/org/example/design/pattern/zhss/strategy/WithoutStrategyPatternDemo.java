package org.example.design.pattern.zhss.strategy;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/3/16
 */
public class WithoutStrategyPatternDemo {

    public static void main(String[] args) {

        int discountStyle = 1;
        if (discountStyle == 1) {
            System.out.println("111");
        } else if (discountStyle == 2) {
            System.out.println("222");
        } else if (discountStyle == 3) {
            System.out.println(333);
        }

    }
}
