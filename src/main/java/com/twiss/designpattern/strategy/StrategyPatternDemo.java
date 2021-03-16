package com.twiss.designpattern.strategy;

/**
 * @Author: Twiss
 * @Date: 2021/3/16 10:33 下午
 * 要点1：必须将if else代码封装到不同的策略中
 * 要点2：将选择那种策略的逻辑给放到一个工厂类中，选择策略的代码务必很简洁
 * 要点3：context可有可无，具体看你的策略执行这一块如果就一行代码不需要context
 * 如果Context中的策略执行逻辑较为复杂一点，context来封装策略类的执行逻辑
 */
public class StrategyPatternDemo {

    public static void main(String[] args) {
        int discountStyle = 2;
        Strategy strategy = Factory.getStrategy(discountStyle);
        Context context = new Context();
        context.setStrategy(strategy);
        Context.execute();
    }

    public interface Strategy {
        void execute();
    }

    public static class StrategyA implements Strategy {
        public void execute() {
            System.out.println("Strategy A logic");
        }
    }

    public static class StrategyB implements Strategy {
        public void execute() {
            System.out.println("Strategy B logic");
        }
    }

    public static class StrategyC implements Strategy {
        public void execute() {
            System.out.println("Strategy C logic");
        }
    }

    public static class Factory {
        public static Strategy getStrategy(int discountStyle) {
            if (discountStyle == 1) {
                return new StrategyA();
            } else if (discountStyle == 2) {
                return new StrategyB();
            } else {
                return new StrategyC();
            }
        }
    }

    public static class Context {
        private static Strategy strategy;

        public Strategy getStrategy() {
            return strategy;
        }

        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        public Context() {

        }

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public static void execute() {
            strategy.execute();
        }
    }
}
