package com.twiss.designpattern.factory;

/**
 * @Author: Twiss
 * @Date: 2021/3/14 1:13 上午
 * （1）就是我们现在要生产的不是一个一个产品，而一个一个的产品组合
 * （2）比如说我们有产品ABC，现在第一种产品组合是A+B，第二种产品组合是B+C，第三种产品组合是A+Cs
 * （3）就是要对工厂模式进行进一步的增强
 */
public class AbstractFactoryPatternDemo {

    public static void main(String[] args) {
        // 产品A1 + B1  ---> A1 + B3只需要在factory中修改即可
        ProductA firstProductA = FactoryImpl1.get().createProductA();
        ProductB firstProductB = FactoryImpl1.get().createProductB();
        firstProductA.operate();
        firstProductB.operate();
        // 产品A2 + B2
        ProductA secondProductA = FactoryImpl2.get().createProductA();
        ProductB secondProductB = FactoryImpl2.get().createProductB();
        secondProductA.operate();
        secondProductB.operate();
    }

    public interface ProductA {
        void operate();
    }

    public interface ProductB {
        void operate();
    }

    public static class ProductA1Impl1 implements ProductA {
        public void operate() {
            System.out.println("产品A的实现1的功能");
        }
    }

    public static class ProductB1Impl1 implements ProductB {
        public void operate() {
            System.out.println("产品B实现1的功能");
        }
    }

    public static class ProductA1Impl2 implements ProductA {
        public void operate() {
            System.out.println("产品A的实现2的功能");
        }
    }

    public static class ProductB1Impl2 implements ProductB {
        public void operate() {
            System.out.println("产品B实现2的功能");
        }
    }

    public interface AbstractFactory {

        ProductA createProductA();

        ProductB createProductB();

    }

    public static class FactoryImpl1 implements AbstractFactory {
        private static final FactoryImpl1 instance = new FactoryImpl1();

        private FactoryImpl1() {

        }

        public static FactoryImpl1 get() {
            return instance;
        }

        public ProductA createProductA() {
            return new ProductA1Impl1();
        }

        public ProductB createProductB() {
            return new ProductB1Impl1();
        }
    }

    public static class FactoryImpl2 implements AbstractFactory {
        private static final FactoryImpl2 instance = new FactoryImpl2();

        public static FactoryImpl2 get() {
            return instance;
        }

        public ProductA createProductA() {
            return new ProductA1Impl2();
        }

        public ProductB createProductB() {
            return new ProductB1Impl2();
        }
    }
}
