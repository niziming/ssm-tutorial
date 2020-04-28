package spring09_aop_account.service.impl;

import spring09_aop_account.dao.AccountDao;
import spring09_aop_account.domain.Account;
import spring09_aop_account.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }
}
