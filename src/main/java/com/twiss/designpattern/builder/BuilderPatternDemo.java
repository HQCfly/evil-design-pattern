package com.twiss.designpattern.builder;

/**
 * @Author: Twiss
 * @Date: 2021/3/14 3:55 下午
 */
public class BuilderPatternDemo {
    public interface Builder {
        void field1(String value);

        void field2(String value);

        Product create();
    }

    public static class Product {
        private String field1;
        private String field2;

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "field1='" + field1 + '\'' +
                    ", field2='" + field2 + '\'' +
                    '}';
        }
    }
    public static class ConcreteBuilder implements Builder{
        private Product product = new Product();
        private ConcreteBuilder(){

        }
        public static Builder build(){
            return new ConcreteBuilder();
        }
        public Product create(){
            return product;
        }
        public void field1(String value){
            System.out.println("Check filed1");
            product.setField1(value);
        }

        public void field2(String value) {
            System.out.println("Check filed2");
            product.setField2(value);
        }
    }
    public static class Director{
        private Builder builder;
        public Director(Builder builder){
            this.builder = builder;
        }
        public Product build(String field1,String field2){

            builder.field1(field1);
            builder.field2(field2);
            return builder.create();
        }
    }

    public static void main(String[] args) {
        Director director = new Director(new ConcreteBuilder());
        Product product = director.build("value 1","value2");
        System.out.println(product.toString());
    }
}
