package aop.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//使用 CGLib 的 Enhancer 类创建代理对
public class Main1 {
    /**
     * 基于子类的动态代理 要求：被代理对象不能是最终类
     * 用到的类：Enhancer
     * 用到的方法：
     * create(Class, Callback)
     * 方法的参数：
     * Class：被代理对象的字节码
     * Callback：如何代理
     * @param args
     */
    public static void main(String[] args) {
        Actor actor = new Actor();

        Actor actorProxy = (Actor) Enhancer.create(
                actor.getClass(),
                new MethodInterceptor() {
                    /**
                     * 执行被代理对象的任何方法，都会经过该方法。
                     * 在此方法内部就可以对被代理对象的任何
                      方法进行增强。
                     *
                     * 参数：
                     * 前三个和基于接口的动态代理是一样的。
                     * MethodProxy：当前执行方法的代理对象。
                     * 返回值：
                     * 当前执行方法的返回值
                     */

                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        String name = method.getName();
                        Float money = (Float) objects[0];
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
        actorProxy.basicAct(1000F);
        actorProxy.dangerAct(4500F);
    }
}
