package com.twiss.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: Twiss
 * @Date: 2021/3/14 10:38 下午
 */
public class ObserverPatternDemo {
    public class Subject extends Observable {

        private String message;

        public String getMessage() {
            return message;
        }

        public void changed() {
            this.setChanged();
            this.notifyObservers(message); // 推模式
            // this.notifyObservers(); // 拉模式
        }

    }
    public class ConcreteObserver implements Observer {

        public void update(Observable o, Object arg) {
            System.out.println(o); // 获取推模式推送过来的数据
            // System.out.println(((Subject)observable).getMessage()); // 拉模式情况下自己去拿数据
        }
    }

}
