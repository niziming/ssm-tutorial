package spring13_jdbc_template.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring13_jdbc_template.domain.Account;
import spring13_jdbc_template.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceImplTest {
    @Autowired
    private AccountService accountService;
    @Test
    public void findAccountById() {
        Account accountById = accountService.findAccountById(1);
        System.out.println(accountById);
    }
}