package org.example.design.pattern.zhss.state;

/**
 * @description: //状态流转，并执行相应的逻辑
 * @author: lvxuhong
 * @date: 2021/3/16
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new NewState());

        context.execute(1);
        context.execute(2);
        context.execute(3);

    }

    interface State {
        void execute();
    }

    public static class NewState implements State {

        @Override
        public void execute() {
            System.out.println("执行新建状态的逻辑");
        }
    }

    public static class ApprovingState implements State {

        @Override
        public void execute() {
            System.out.println("执行待审批状态的逻辑");
        }
    }

    public static class ApprovedState implements State {

        @Override
        public void execute() {
            System.out.println("执行已审批状态的逻辑");
        }
    }

    public static class FinishState implements State {

        @Override
        public void execute() {
            System.out.println("执行已完成状态的逻辑");
        }
    }

    public static class Context {
        private State state;

        public Context(State state) {
            this.state = state;
            this.state.execute();
        }

        public void execute(int state) {
            //状态流转，并执行相应的逻辑
            if (state == 1) {
                this.state = new ApprovingState();
                this.state.execute();
            } else if (state == 2) {
                this.state = new ApprovedState();
                this.state.execute();
            } else if (state == 3) {
                this.state = new FinishState();
                this.state.execute();
            }
        }

    }
}
