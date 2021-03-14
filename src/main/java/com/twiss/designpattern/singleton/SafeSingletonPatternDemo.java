package com.twiss.designpattern.singleton;

/**
 * @Author: Twiss
 * @Date: 2021/3/14 3:19 下午
 */
public class SafeSingletonPatternDemo {
    private static SafeSingletonPatternDemo instance;
    public static SafeSingletonPatternDemo getInstance(){
        if (instance==null){
            synchronized (SafeSingletonPatternDemo.class){
                if (instance==null){
                    SafeSingletonPatternDemo.instance = new SafeSingletonPatternDemo();
                }
            }
        }
        return instance;
    }
}
