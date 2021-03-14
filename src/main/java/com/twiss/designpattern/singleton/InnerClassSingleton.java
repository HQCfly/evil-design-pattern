package com.twiss.designpattern.singleton;

/**
 * @Author: Twiss
 * @Date: 2021/3/14 3:22 下午
 */
public class InnerClassSingleton {
    private InnerClassSingleton(){

    }
    private static class LazyHolder{
        private static final InnerClassSingleton singleton = new InnerClassSingleton();
    }
    public static InnerClassSingleton getInstance(){
        return LazyHolder.singleton;
    }
}
