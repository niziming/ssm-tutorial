package spring06_xml_ioc.service.impl;

import spring06_xml_ioc.dao.AccountDao;
import spring06_xml_ioc.domain.Account;
import spring06_xml_ioc.service.AccountSevice;

import java.util.List;

public class AccountServiceImpl implements AccountSevice {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        List<Account> allAccount = accountDao.findAllAccount();
        return allAccount;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return null;
    }

    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(Integer acccountId) {

    }
}
