package spring16_account_transaction.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring16_account_transaction.domain.Account;
import spring16_account_transaction.service.AccountService;

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
}