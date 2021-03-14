package com.twiss.designpattern.singleton;

/**
 * @Author: Twiss
 * @Date: 2021/3/14 2:58 下午
 */
public class HungrySingletonPatternDemo {
    private static final HungrySingletonPatternDemo instance = new HungrySingletonPatternDemo();
    private HungrySingletonPatternDemo(){

    }
    public static HungrySingletonPatternDemo getInstance(){
        return instance;
    }
}
