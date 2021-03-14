package com.twiss.designpattern.builder;

/**
 * @Author: Twiss
 * @Date: 2021/3/14 4:37 下午
 */
public class OptimizedBuilderPatternDemo {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder().field1("value1").field2("value2");
        System.out.println(builder.toString());
    }

    public interface Builder {
        Builder field1(String value);

        Builder field2(String value);

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
    public static class ConcreteBuilder implements Builder {
        private Product product = new Product();
        private ConcreteBuilder(){

        }
        public Product create(){
            return product;
        }
        public Builder field1(String value){
            System.out.println("Check filed1");
            product.setField1(value);
            return this;
        }

        public Builder field2(String value) {
            System.out.println("Check filed2");
            product.setField2(value);
            return this;
        }

        @Override
        public String toString() {
            return "ConcreteBuilder{" +
                    "product=" + product +
                    '}';
        }
    }
}
