package com.twiss.designpattern.template;

/**
 * @Author: Twiss
 * @Date: 2021/3/12 12:02 上午
 * 场景：
 * （1）我们有多种优惠策略
 * （2）不同的优惠策略在计算的价格的时候，有一些通用的基础逻辑
 * （3）每种优惠策略还有一些是自己特殊的价格计算的逻辑
 */
public class TemplateMethodPatternDemo {

    public static void main(String[] args) {
        DiscountCalculator discountCalculator1 = new DiscountCalculate1();
        DiscountCalculator discountCalculator2 = new DiscountCalculate2();
        DiscountCalculator discountCalculator3 = new DiscountCalculate3();
        discountCalculator1.calculate();
        discountCalculator2.calculate();
        discountCalculator3.calculate();

    }

    public interface DiscountCalculator {
        void calculate();
    }

    /**
     * 模板方法核心
     */
    public static abstract class AbstractDiscountCalculate implements DiscountCalculator {
        public void calculate() {
            commonCalculate();
            specificCalculate();
        }

        private void commonCalculate() {
            System.out.println("Common calculate logic");
        }

        protected abstract void specificCalculate();
    }

    public static class DiscountCalculate1 extends AbstractDiscountCalculate {
        public void specificCalculate() {
            System.out.println("Special calculate1 logic");
        }
    }

    public static class DiscountCalculate2 extends AbstractDiscountCalculate {
        public void specificCalculate() {
            System.out.println("Special calculate2 logic");
        }
    }

    public static class DiscountCalculate3 extends AbstractDiscountCalculate {
        public void specificCalculate() {
            System.out.println("Special calculate3 logic");
        }
    }
}
