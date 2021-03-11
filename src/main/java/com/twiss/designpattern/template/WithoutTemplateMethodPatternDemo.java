package com.twiss.designpattern.template;

/**
 * @Author: Twiss
 * @Date: 2021/3/12 12:02 上午
 *
 */
public class WithoutTemplateMethodPatternDemo {
    public static void main(String[] args) {
        DiscountCalculate1 discountCalculate1 = new DiscountCalculate1();
        DiscountCalculate2 discountCalculate2 = new DiscountCalculate2();
        DiscountCalculate3 discountCalculate3 = new DiscountCalculate3();
        discountCalculate1.calculate1();
        discountCalculate2.calculate2();
        discountCalculate3.calculate3();
    }

    public static class DiscountCalculate1{
        public void calculate1(){
            System.out.println("Common calculate logic");
            System.out.println("Special calculate1 logic");
        }
    }

    public static class DiscountCalculate2{
        public void calculate2(){
            System.out.println("Common calculate logic");
            System.out.println("Special calculate2 logic");
        }
    }

    public static class DiscountCalculate3{
        public void calculate3(){
            System.out.println("Common calculate logic");
            System.out.println("Special calculate3 logic");
        }
    }

}
