package spring04ioc_crud.service.impl;

import spring04ioc_crud.dao.AccountDao;
import spring04ioc_crud.dao.impl.AccountDaoImpl;
import spring04ioc_crud.entity.Account;
import spring04ioc_crud.mapper.AccountMapper;
import spring04ioc_crud.service.AccountService;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    AccountDao accountDao;

    public AccountServiceImpl() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void getAll() throws SQLException, ClassNotFoundException {
        accountDao.save(new Account());
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
