package spring06_xml_ioc.service.impl;

import spring06_xml_ioc.dao.AccountDao;
import spring06_xml_ioc.service.AccountSevice;

public class AccountServiceImpl implements AccountSevice {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
