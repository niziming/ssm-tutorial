package spring14_aop_transaction.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring14_aop_transaction.dao.AccountDao;
import spring14_aop_transaction.domain.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountDaoImplTest {
    @Autowired
    AccountDao accountDao;
    @Test
    public void findAccountById() {
        Account accountById = accountDao.findAccountById(1);
        System.out.println(accountById);
    }
}