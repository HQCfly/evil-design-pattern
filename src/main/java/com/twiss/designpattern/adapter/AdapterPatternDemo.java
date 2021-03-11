package com.twiss.designpattern.adapter;

/**
 * @Author: Twiss
 * @Date: 2021/3/11 11:15 下午
 * 场景介绍：
 * （1）假设我们做了一个第一版的一个系统，这个系统里有一个接口和一个实现类
 * （2）接着我们开始做第二版的系统，这个系统我们定义了一个新的接口，和新的实现类
 * （3）但是我们同时在第二版的系统中，也要使用第一版系统中定义的那个老接口和老实现类
 */
public class AdapterPatternDemo {

    public static void main(String[] args) {
        NewInterface oldObject = new NewInterfaceAdapter(new OldInterfaceImpl());
        NewInterface newObject = new NewInterfaceImpl();
        oldObject.newExecute();
        newObject.newExecute();
    }

    /**
     * 定义一个适配器类
     */
    public static class NewInterfaceAdapter implements NewInterface {
        private OldInterface oldObject;

        public NewInterfaceAdapter(OldInterface oldObject){
            this.oldObject = oldObject;
        }
        public void newExecute() {
            oldObject.oldExecute();
        }
    }


    public static interface OldInterface{
        void oldExecute();
    }
    public static class OldInterfaceImpl implements OldInterface{

        public void oldExecute() {
            System.out.println("Old version");
        }
    }

    public static interface NewInterface{
        void newExecute();
    }
    public static class NewInterfaceImpl implements NewInterface{

        public void newExecute() {
            System.out.println("New version");
        }
    }
}
