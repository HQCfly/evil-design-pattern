package com.twiss.designpattern.builder;

/**
 * @Author: Twiss
 * @Date: 2021/3/14 3:48 下午
 */
public class WithoutBuilderPatternDemo {
    public static void main(String[] args) {
        Product product = new Product();
        System.out.println("Check filed1");
        product.setField1("值1");
        System.out.println("Check filed2");
        product.setField2("值2");
        System.out.println("Check filed3");
        product.setField3("值3");

    }

    public static class Product{
        private String field1;
        private String field2;

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }

        private String field3;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public Product() {

        }

        public Product(String field1, String field2, String field3) {
            this.field1 = field1;
            this.field2 = field2;
            this.field3 = field3;
        }
    }
}
