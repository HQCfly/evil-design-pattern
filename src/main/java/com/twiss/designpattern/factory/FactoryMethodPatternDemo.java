package com.twiss.designpattern.factory;

/**
 * @Author: Twiss
 * @Date: 2021/3/13 12:34 上午
 * 场景：
 * （1）我们现在要生产的产品有多种
 * （2）每种产品的生产过程，都有一些是共同的逻辑，但是也有一些是特殊的逻辑
 * （3）现在要生产出来各种产品
 */
public class FactoryMethodPatternDemo {

    public static void main(String[] args) {
        Product product1 = ConcreteCreator.get().create();
        Product product2 = ConcreteCreator2.get().create();

        product1.method();
        product2.method();
    }

    public interface Product {
        void method();
    }
    public static class ConcreteProduct implements Product{
        public void method(){
            System.out.println("Special method");
        }
    }
    public static class ConcreteProduct2 implements Product{
        public void method(){
            System.out.println("Special2 method");
        }
    }
    public static abstract class Creator{
        public Product create(){
            System.out.println("Common method");
            return factoryMethod();
        }
        public abstract Product factoryMethod();
    }

    public static class ConcreteCreator extends Creator{
        private static final ConcreteCreator instance = new ConcreteCreator();
        public Product factoryMethod(){
            System.out.println("Product special logic");
            return new ConcreteProduct();
        }
        public static ConcreteCreator get(){
            return instance;
        }
    }

    public static class ConcreteCreator2 extends Creator{
        private static final ConcreteCreator2 instance = new ConcreteCreator2();
        public Product factoryMethod(){
            System.out.println("Product2 special logic");
            return new ConcreteProduct2();
        }
        public static ConcreteCreator2 get(){
            return instance;
        }
    }

}
