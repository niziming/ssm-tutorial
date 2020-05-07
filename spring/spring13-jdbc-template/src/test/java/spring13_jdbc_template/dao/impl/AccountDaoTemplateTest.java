package spring13_jdbc_template.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring13_jdbc_template.dao.AccountDao;
import spring13_jdbc_template.domain.Account;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountDaoTemplateTest {
    @Qualifier("accountDaoTemplate")
    @Autowired
    AccountDao accountDao;
    @Test
    public void findAccountById() {
        Account accountById = accountDao.findAccountById(1);
        System.out.println(accountById);
    }

}