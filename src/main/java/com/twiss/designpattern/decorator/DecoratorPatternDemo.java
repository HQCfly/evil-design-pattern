package com.twiss.designpattern.decorator;

/**
 * @Author: Twiss
 * @Date: 2021/3/17 12:10 上午
 */
public class DecoratorPatternDemo {

    public interface Component {

        void operate();

    }
    public class ConcreteComponent implements Component {

        public void operate() {
            System.out.println("组件的功能");
        }

    }
    public class Decorator implements Component {

        protected Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        public void operate() {
            System.out.println("实现某些动态加强功能");
            component.operate();
            System.out.println("实现某些动态加强功能");
        }

    }
}
