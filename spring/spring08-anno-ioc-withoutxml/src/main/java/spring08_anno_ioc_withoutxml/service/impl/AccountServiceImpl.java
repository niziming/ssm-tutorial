package spring08_anno_ioc_withoutxml.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring08_anno_ioc_withoutxml.dao.AccountDao;
import spring08_anno_ioc_withoutxml.domain.Account;
import org.springframework.stereotype.Service;
import spring08_anno_ioc_withoutxml.service.AccountService;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAllAccount() {
        List<Account> allAccount = accountDao.findAllAccount();
        return allAccount;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        accountDao.deleteAccount(acccountId);
    }
}
