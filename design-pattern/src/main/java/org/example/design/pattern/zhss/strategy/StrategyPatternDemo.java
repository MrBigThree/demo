package org.example.design.pattern.zhss.strategy;

/**
 * @description: //TODO
 * @author: lvxuhong
 * @date: 2021/3/16
 */
public class StrategyPatternDemo {

    public static void main(String[] args) {
        int discountStyle = 1;
        DiscountCalculateStrategy discountCalculateStrategy = DiscountCalculateStrategyFactory.getDiscountCalculateStrategy(discountStyle);
        discountCalculateStrategy.calculate();
    }

    interface DiscountCalculateStrategy {
        void calculate();
    }

    public static class DiscountCalculateStrategyA implements DiscountCalculateStrategy {

        @Override
        public void calculate() {
            System.out.println("A");
        }
    }

    public static class DiscountCalculateStrategyB implements DiscountCalculateStrategy {

        @Override
        public void calculate() {
            System.out.println("B");
        }
    }

    public static class DiscountCalculateStrategyC implements DiscountCalculateStrategy {

        @Override
        public void calculate() {
            System.out.println("C");
        }
    }

    public static class DefaultDiscountCalculateStrategy implements DiscountCalculateStrategy {

        @Override
        public void calculate() {
            System.out.println("默认");
        }
    }

    public static class DiscountCalculateStrategyFactory {
        public static DiscountCalculateStrategy getDiscountCalculateStrategy(int discountStyle) {
            if (discountStyle == 1) {
                return new DiscountCalculateStrategyA();
            } else if (discountStyle == 2) {
                return new DiscountCalculateStrategyB();
            } else if (discountStyle == 3) {
                return new DiscountCalculateStrategyC();
            }
            return new DefaultDiscountCalculateStrategy();
        }
    }
}
