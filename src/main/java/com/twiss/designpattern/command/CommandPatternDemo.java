package com.twiss.designpattern.command;

/**
 * @Author: Twiss
 * @Date: 2021/3/14 11:29 下午
 */
public class CommandPatternDemo {
    public interface Command {

        void execute();

    }
    public class CommandA implements Command {

        public void execute() {
            System.out.println("命令A的逻辑");
        }

    }
    public class CommandB implements Command {

        public void execute() {
            System.out.println("命令B的逻辑");
        }

    }
    public class Invoker {

        private Command command;

        public Invoker(Command command) {
            this.command = command;
        }

        public void execute() {
            command.execute();
        }

    }

}
