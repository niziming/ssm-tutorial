package aop.service.impl;

import aop.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import aop.dao.AccountDao;
import aop.domain.Account;
import org.springframework.stereotype.Service;
import aop.service.AccountService;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private TransactionManager transactionManager;
    @Override
    public List<Account> findAllAccount() {
        List<Account> allAccount = null;
        try {
            transactionManager.beginTransaction();
            allAccount = accountDao.findAllAccount();
            transactionManager.commit();
            transactionManager.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allAccount;
    }
    @Override
    public Account findAccountById(Integer accountId) {
        Account account = null;
        try {
            transactionManager.beginTransaction();
            account = accountDao.findAccountById(accountId);
            transactionManager.commit();
            transactionManager.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }

}
