package spring08_anno_ioc_withoutxml.service.impl;

import spring08_anno_ioc_withoutxml.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring08_anno_ioc_withoutxml.domain.Account;
import spring08_anno_ioc_withoutxml.service.AccountService;

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
}