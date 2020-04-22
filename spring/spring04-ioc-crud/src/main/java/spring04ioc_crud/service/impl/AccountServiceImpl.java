package spring04ioc_crud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring04ioc_crud.dao.AccountDao;
import spring04ioc_crud.entity.Account;
import spring04ioc_crud.service.AccountService;

import java.sql.SQLException;

/*
    使用@Component注解配置管理的资源
 */
@Component("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
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
