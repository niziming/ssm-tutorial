package aop.service.impl;

import aop.dao.AccountDao;
import aop.domain.Account;
import aop.service.AccountService;

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

    @Override
    public void transfer(String source, String target, Float money) {
        System.out.println(source + "向" + target + "转账" + money + "元");
    }
}
