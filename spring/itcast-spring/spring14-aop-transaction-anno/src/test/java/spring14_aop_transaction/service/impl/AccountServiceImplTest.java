package spring14_aop_transaction.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring14_aop_transaction.domain.Account;
import spring14_aop_transaction.service.AccountService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceImplTest {
    @Autowired
    AccountService accountService;
    @Test
    public void findAccountById() {
        Account accountById = accountService.findAccountById(1);
        System.out.println(accountById);
    }

    @Test
    public void transfer() {
        accountService.transfer(9, 12, 1000.0F);
    }

    @Test
    public void updateAccount() {
        accountService.updateAccount(new Account(1, "ziming", 1000.0F));
    }
}