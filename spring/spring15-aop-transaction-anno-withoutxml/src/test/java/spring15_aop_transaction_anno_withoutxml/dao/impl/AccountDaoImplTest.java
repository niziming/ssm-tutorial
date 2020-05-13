package spring15_aop_transaction_anno_withoutxml.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring15_aop_transaction_anno_withoutxml.config.SpringConfiguration;
import spring15_aop_transaction_anno_withoutxml.dao.AccountDao;
import spring15_aop_transaction_anno_withoutxml.domain.Account;

import javax.sql.DataSource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountDaoImplTest {
    @Value("${jdbc.driver}")
    String driver;

    @Autowired
    AccountDao accountDao;
    @Autowired
    DataSource dataSource;
    @Test
    public void findAccountById() {
        System.out.println(driver);
        System.out.println(dataSource);
        Account accountById = accountDao.findAccountById(1);
        System.out.println(accountById);
    }
}