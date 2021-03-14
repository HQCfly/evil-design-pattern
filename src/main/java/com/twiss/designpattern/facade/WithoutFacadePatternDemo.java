package com.twiss.designpattern.facade;

/**
 * @Author: Twiss
 * @Date: 2021/3/14 3:32 下午
 */
public class WithoutFacadePatternDemo {
    public static void main(String[] args) {
        ModuleA moduleA = new ModuleA();
        ModuleB moduleB = new ModuleB();
        ModuleC moduleC = new ModuleC();
        moduleA.execute();
        moduleB.execute();
        moduleC.execute();
    }
    public static class ModuleA{
        public void execute(){
            System.out.println("ModuleA");
        }
    }
    public static class ModuleB{
        public void execute(){
            System.out.println("ModuleB");
        }
    }
    public static class ModuleC{
        public void execute(){
            System.out.println("ModuleC");
        }
    }
}
