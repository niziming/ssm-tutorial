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
        return accountDao.findAllAccount();
    }
    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }
}
