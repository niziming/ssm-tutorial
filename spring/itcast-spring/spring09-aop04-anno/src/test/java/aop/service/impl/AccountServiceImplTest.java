package aop.service.impl;

import aop.config.SpringConfiguration;
import aop.factory.BeanFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import aop.domain.Account;
import aop.service.AccountService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceImplTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void findAllAccount() {
        List<Account> allAccount = accountService.findAllAccount();
        System.out.println(allAccount);
    }

    @Test
    public void findAccountById() {
        Account accountById = accountService.findAccountById(1);
        System.out.println(accountById);
    }
}