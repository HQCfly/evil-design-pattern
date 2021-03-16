package com.twiss.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2021/3/16 11:33 下午
 */
public class FlyweightPatternDemo {
    public static void main(String[] args) {
        Flyweight flyweight1 = FlyweightFactory.getFlyweight("对象1");
        flyweight1.operate();

        Flyweight flyweight2 = FlyweightFactory.getFlyweight("对象1");
        flyweight2.operate();

        System.out.println(flyweight1==flyweight2);
    }
    public interface Flyweight {

        void operate();

    }

    public static class ConcreteFlyweight implements Flyweight {

        public void operate() {

        }
    }

    public static class FlyweightFactory {

        private static Map<String, Flyweight> map = new HashMap<String, Flyweight>();

        public static Flyweight getFlyweight(String key) {
            Flyweight flyweight = map.get(key);

            if (flyweight == null) {
                flyweight = new ConcreteFlyweight();
                map.put(key, flyweight);
            }

            return flyweight;
        }

    }

}
