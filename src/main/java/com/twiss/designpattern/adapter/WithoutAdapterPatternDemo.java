package com.twiss.designpattern.adapter;

/**
 * @Author: Twiss
 * @Date: 2021/3/11 11:15 下午
 */
public class WithoutAdapterPatternDemo {

    public static void main(String[] args) {
        OldInterface oldObject = new OldInterfaceImpl();
        NewInterface newObject = new NewInterfaceImpl();

        oldObject.oldExecute();
        newObject.newExecute();
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
