package aop.service.impl;

import aop.dao.AccountDao;
import aop.domain.Account;
import aop.service.AccountService;
import aop.utils.TransactionManager;

import java.util.List;

public class AccountServiceImplOLD implements AccountService {
    private AccountDao accountDao;
    private TransactionManager transactionManager;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
    @Override
    public List<Account> findAllAccount() {
        List<Account> accounts = null;
        try{
            // 1.开启事务
            transactionManager.beginTransaction();
            // 2.执行操作
            accounts = accountDao.findAllAccount();
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
            e.printStackTrace();
        } finally {
            transactionManager.release();
        }
        return accounts;
    }

    @Override
    public void transfer(String source, String target, Float money) {

    }
}
