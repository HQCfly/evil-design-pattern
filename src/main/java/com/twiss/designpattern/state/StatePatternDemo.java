package com.twiss.designpattern.state;


/**
 * @Author: Twiss
 * @Date: 2021/3/16 11:03 下午
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new StateA());
        context.execute(1);
        context.execute(2);
        context.execute(3);
    }

    public interface State {
        void execute();
    }

    public static class StateA implements State {
        public void execute() {
            System.out.println("State1");
        }
    }

    public static class StateB implements State {
        public void execute() {
            System.out.println("State2");
        }
    }

    public static class StateC implements State {
        public void execute() {
            System.out.println("State3");
        }
    }

    public static class Context {
        private State state;
        public Context(State state) {
            this.state = state;
        }

        public void execute(int stateType) {
            if (stateType==1){
                this.state = new StateA();
                this.state.execute();
            } else if (stateType==2){
                this.state = new StateB();
                this.state.execute();
            } else {
                this.state = new StateC();
                this.state.execute();
            }
        }
    }
}
