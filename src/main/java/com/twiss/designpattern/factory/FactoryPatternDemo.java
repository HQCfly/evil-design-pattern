package com.twiss.designpattern.factory;

/**
 * @Author: Twiss
 * @Date: 2021/3/12 11:13 下午
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        Product product = Factory.createProduct();
        System.out.println(product.execute());
    }

    public interface Product{
        boolean execute();
    }

    public static class ProductImpl implements Product{
        public boolean execute(){
            System.out.println("Sample interface");
            return false;
        }
    }

    public static class Factory{
        public static Product createProduct(){
            return new ProductImpl();
        }
    }


}
