package aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    /**
     * 代理：间接。获取代理对象：
     * 要求：被代理类最少实现一个接口
     * 创建的方式
     * Proxy.newProxyInstance(三个参数)
     * 参数含义：
     * ClassLoader：和被代理对象使用相同的类加载器。
     * Interfaces：和被代理对象具有相同的行为。实现相同的接口。
     * InvocationHandler：如何代理。
     * 策略模式：使用场景是：
     * 数据有了，目的明确。
     * 如何达成目标，就是策略。
     */
    public static void main(String[] args) {
        //一个剧组找演员：
        final Actor actor = new Actor();//直接

        //通过代理
        IActor proxyActor = (IActor) Proxy.newProxyInstance(
            actor.getClass().getClassLoader(),
            actor.getClass().getInterfaces(),
            new InvocationHandler() {
                /**
                 * 执行被代理对象的任何方法，都会经过该方法。
                 * 此方法有拦截的功能。
                 * 参数：
                 * proxy：代理对象的引用。不一定每次都用得到
                 * method：当前执行的方法对象
                 * args：执行方法所需的参数
                 * 返回值：
                 * 当前执行方法的返回值
                 */
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    String name = method.getName();
                    Float money = (Float) args[0];
                    Object rtValue = null;
                    //每个经纪公司对不同演出收费不一样，此处开始判断
                    if("basicAct".equals(name)){
                        //基本演出，没有 2000 不演
                        if(money > 2000){
                            //看上去剧组是给了 8000，实际到演员手里只有 4000
                            //这就是我们没有修改原来 basicAct 方法源码，对方法进行了增强
                            rtValue = method.invoke(actor, money/2);
                        } else {
                            System.out.println("基本演出钱太少实际拿到" + money/2 + ", 放弃演出");
                        }
                    }
                    if("dangerAct".equals(name)){
                        //危险演出,没有 5000 不演
                        if(money > 5000){
                            //看上去剧组是给了 50000，实际到演员手里只有 25000
                            //这就是我们没有修改原来 dangerAct 方法源码，对方法进行了增强
                            rtValue = method.invoke(actor, money/2);
                        } else {
                            System.out.println("危险演出收入低于5000, "+ "实际获得" + money/2 + "放弃演出");
                        }
                    }
                    return rtValue;
                }
            }
        );
        proxyActor.basicAct(1000F);
        proxyActor.dangerAct(4500F);

    }
}
