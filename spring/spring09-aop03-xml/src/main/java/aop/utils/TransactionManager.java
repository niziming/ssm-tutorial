package aop.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
 */
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction() {
        try {
            System.out.println("开启事务");
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit() {
        try {
            System.out.println("提交事务");
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            System.out.println("回滚事务");
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public void release() {
        try {
            System.out.println("释放连接");
            connectionUtils.getThreadConnection().close();//还回连接池中
            connectionUtils.removeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 环绕通知
     *
     * @param pjp spring 框架为我们提供了一个接口：ProceedingJoinPoint，它可以作为环绕通知的方法参数。
     *            在环绕通知执行时，spring 框架会为我们提供该接口的实现类对象，我们直接使用就行。
     * @return
     */
    public Object transactionAround(ProceedingJoinPoint pjp) {
        //定义返回值
        Object rtValue = null;
        try {
            //获取方法执行所需的参数
            Object[] args = pjp.getArgs();
            //前置通知：开启事务
            System.out.println("开启事务");
            beginTransaction();
            //执行方法
            rtValue = pjp.proceed(args);
            //后置通知：提交事务
            System.out.println("提交事务");
            commit();
        } catch (Throwable e) {
            //异常通知：回滚事务
            System.out.println("回滚事务");
            rollback();
            e.printStackTrace();
        } finally {
            //最终通知：释放资源
            System.out.println("释放连接");
            release();
        }
        return rtValue;
    }

}
