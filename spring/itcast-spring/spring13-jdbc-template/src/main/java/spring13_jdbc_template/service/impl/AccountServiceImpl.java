package spring13_jdbc_template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring13_jdbc_template.dao.AccountDao;
import spring13_jdbc_template.domain.Account;
import spring13_jdbc_template.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    @Qualifier("accountDaoImpl")
    @Autowired
    private AccountDao accountDao;
    @Override
    public Account findAccountById(Integer accountId) {
        Account accountById = accountDao.findAccountById(1);
        return accountById;
    }

    @Override
    public Account findAccountByName(String accountName) {
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }
}
