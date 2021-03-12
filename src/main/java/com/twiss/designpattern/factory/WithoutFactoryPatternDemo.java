package com.twiss.designpattern.factory;

/**
 * @Author: Twiss
 * @Date: 2021/3/12 11:05 下午
 * 如果Product改成Product2，那么main函数中也需要修改
 */
public class WithoutFactoryPatternDemo {

    public static void main(String[] args) {
        Product product = new Product("Test Product");
        System.out.println(product);
    }

    public static class Product {
        private String name;

        public Product(String name) {
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
