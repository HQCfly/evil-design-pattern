package com.twiss.designpattern.chain;

/**
 * @Author: Twiss
 * @Date: 2021/3/17 12:20 上午
 */
public class ChainPatternDemo {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);
        handler2.handleRequest();
    }
    public static abstract class Handler {

        protected Handler successor;

        public Handler(Handler handler) {
            this.successor = handler;
        }

        public abstract void handleRequest();

    }

    public static class ConcreteHandler1 extends Handler {
        public ConcreteHandler1(Handler handler){
            super(handler);
        }
        public void handleRequest() {
            System.out.println("ConcreteHandler1实现代码");
            this.successor.handleRequest();
        }

    }
    public static class ConcreteHandler2 extends Handler {
        public ConcreteHandler2(Handler handler){
            super(handler);
        }
        public void handleRequest() {
            System.out.println("ConcreteHandler2实现代码");
            this.successor.handleRequest();
        }

    }
}
