package aop.factory;

import aop.service.AccountService;
import aop.service.impl.AccountServiceImpl;
import aop.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class BeanFactory {
    @Autowired
    TransactionManager transactionManager;
    @Autowired
    AccountService accountService;
    /**
     * 创建账户业务层实现类的代理对象
     * @return
     */
    public AccountService getAccountService() {
        //1.定义被代理对象
        //final AccountService accountService = new AccountServiceImpl();
        AccountService asProxy = (AccountService) Enhancer.create(
                accountService.getClass(),
                new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        Object rtValue = null;
                        try {
                            //开启事务
                            transactionManager.beginTransaction();
                            //执行业务层方法
                            rtValue = method.invoke(accountService, objects);
                            //提交事务
                            transactionManager.commit();
                        }catch(Exception e) {
                            //回滚事务
                            transactionManager.rollback();
                            e.printStackTrace();
                        }finally {
                            //释放资源
                            transactionManager.release();
                        }
                        return rtValue;
                    }
                }
        );
        return asProxy;
    }
}
