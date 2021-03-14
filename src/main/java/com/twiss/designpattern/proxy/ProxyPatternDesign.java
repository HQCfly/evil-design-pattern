package com.twiss.designpattern.proxy;

/**
 * @Author: Twiss
 * @Date: 2021/3/14 9:58 下午
 */
public class ProxyPatternDesign {
    public interface Subject {

        void request();

    }
    public class ConcreteSubject implements Subject {

        public void request() {
            System.out.println("执行功能");
        }

    }
    public class Proxy implements Subject {

        private Subject subject;

        public Proxy(Subject subject) {
            this.subject = subject;
        }

        public void request() {
            subject.request();
        }

    }

}
