package spring14_aop_transaction.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
@Aspect
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* spring14_aop_transaction.service.impl.*.*(..))")
    public void transaction() {}

    /**
     * 开启事物
     */
    @Before("transaction()")
    public void beginTransaction(){
        System.out.println("开启事物");
        try {
            System.out.println("设置自动提交为否");
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事物
     */
    @AfterReturning("transaction()")
    public void commit(){
        System.out.println("提交事物");
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事物
     */
    @AfterThrowing("transaction()")
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    @After("transaction()")
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
