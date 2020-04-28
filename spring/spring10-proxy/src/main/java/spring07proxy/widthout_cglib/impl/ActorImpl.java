package spring07proxy.widthout_cglib.impl;

public class ActorImpl implements Actor {

    @Override
    public void basicAct(float money) {
        System.out.println("开始表演: " + money);
    }

    @Override
    public void dangerAct(float money) {
        System.out.println("开始危险的表演: " + money);
    }
}
