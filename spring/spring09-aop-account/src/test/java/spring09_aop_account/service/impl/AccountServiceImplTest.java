package spring09_aop_account.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring09_aop_account.domain.Account;
import spring09_aop_account.service.AccountService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceImplTest {
    @Qualifier("proxyAccountService")
    @Autowired
    // private AccountService accountService;
    private AccountService proxyAccountService;
    @Test
    public void findAllAccount() {
        // List<Account> allAccount = accountService.findAllAccount();
        // System.out.println(allAccount);
        List<Account> allAccount = proxyAccountService.findAllAccount();
        System.out.println(allAccount);
    }
}