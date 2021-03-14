package com.twiss.designpattern.facade;

/**
 * @Author: Twiss
 * @Date: 2021/3/14 3:37 下午
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        SystemFacade systemFacade = new SystemFacade();
        systemFacade.execute();
    }

    public static class SystemFacade{
       public void execute(){
           // 好处1：子系统不需要care多个模块，只要关心一个门面类
           // 好处2：如果多个地方都要调用这段逻辑，那么只需要在门面类中修改即可
           ModuleA moduleA = new ModuleA();
           ModuleB moduleB = new ModuleB();
           ModuleC moduleC = new ModuleC();

           moduleA.execute();
           moduleB.execute();
           moduleC.execute();
       }
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
