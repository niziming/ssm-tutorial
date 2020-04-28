package spring09_aop_account.factory;

import spring09_aop_account.service.AccountService;
import spring09_aop_account.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
    private AccountService accountService;

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 获取Service代理对象
     *
     * @return
     */
    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
            accountService.getClass().getInterfaces(),
            new InvocationHandler() {
                /**
                 * 添加事务的支持
                 *
                 * @param proxy
                 * @param method
                 * @param args
                 * @return
                 * @throws Throwable
                 */
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if ("test".equals(method.getName())) {
                        return method.invoke(accountService, args);
                    }
                    Object rtValue = null;
                    try {
                        //1.开启事务
                        transactionManager.beginTransaction();
                        //2.执行操作
                        rtValue = method.invoke(accountService, args);
                        //3.提交事务
                        transactionManager.commit();
                        //4.返回结果
                    } catch (Exception e) {
                        //5.回滚操作
                        transactionManager.rollback();
                        throw new RuntimeException(e);
                    } finally {
                        //6.释放连接
                        transactionManager.release();
                    }
                    return rtValue;
                }
        });
    }
}
