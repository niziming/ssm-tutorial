package spring02ioc.dao.impl;

import spring02ioc.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存账户");
    }
}
