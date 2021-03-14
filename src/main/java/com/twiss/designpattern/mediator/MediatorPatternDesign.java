package com.twiss.designpattern.mediator;


/**
 * @Author: Twiss
 * @Date: 2021/3/14 8:45 下午
 */
public class MediatorPatternDesign {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        ModuleA moduleA = new ModuleA(mediator);
        ModuleB moduleB = new ModuleB(mediator);
        ModuleC moduleC = new ModuleC(mediator);
        moduleA.execute();
        moduleB.execute();
        moduleC.execute();
    }
    public static class Mediator {
        private ModuleA moduleA;
        private ModuleB moduleB;
        private ModuleC moduleC;

        public ModuleA getModuleA() {
            return moduleA;
        }

        public void setModuleA(ModuleA moduleA) {
            this.moduleA = moduleA;
        }

        public ModuleB getModuleB() {
            return moduleB;
        }

        public void setModuleB(ModuleB moduleB) {
            this.moduleB = moduleB;
        }

        public ModuleC getModuleC() {
            return moduleC;
        }

        public void setModuleC(ModuleC moduleC) {
            this.moduleC = moduleC;
        }

        public void moduleAInvoke() {
            moduleC.execute("模块A通知中介者");
            moduleB.execute("模块A通知中介者");
        }

        public void moduleBInvoke() {
            moduleA.execute("模块B通知中介者");
            moduleB.execute("模块B通知中介者");
        }


        public void moduleCInvoke() {
            moduleA.execute("模块C通知中介者");
            moduleB.execute("模块C通知中介者");
        }

    }

    public static class ModuleA {
        private Mediator mediator;

        public ModuleA(Mediator mediator) {
            this.mediator = mediator;
            this.mediator.setModuleA(this);
        }

        public void execute() {
            mediator.moduleAInvoke();
        }

        public static void execute(String invoke) {
            System.out.println(invoke + "在调用模块A的功能");
        }
    }

    public static class ModuleB {
        private Mediator mediator;

        public ModuleB(Mediator mediator) {
            this.mediator = mediator;
            this.mediator.setModuleB(this);
        }

        public void execute() {
            mediator.moduleBInvoke();
        }

        public void execute(String invoke) {
            System.out.println(invoke + "在调用模块B的功能");
        }
    }

    public static class ModuleC {
        private Mediator mediator;

        public ModuleC(Mediator mediator) {
            this.mediator = mediator;
            this.mediator.setModuleC(this);
        }

        public void execute() {
            mediator.moduleCInvoke();
        }

        public static void execute(String invoke) {
            System.out.println(invoke + "在调用模块C的功能");
        }
    }
}
