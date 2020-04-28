package spring07proxy.cglib;

public class Actor implements spring07proxy.widthout_cglib.impl.Actor {

    @Override
    public void basicAct(float money) {
        System.out.println("开始表演: " + money);
    }

    @Override
    public void dangerAct(float money) {
        System.out.println("开始危险的表演: " + money);
    }
}
