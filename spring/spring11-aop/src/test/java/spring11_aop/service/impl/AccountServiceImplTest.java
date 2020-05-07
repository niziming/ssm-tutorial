package spring11_aop.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring11_aop.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceImplTest {
    // @Qualifier("accountService")
    @Autowired
    private AccountService accountService;

    @Test
    public void saveAccount() {

        accountService.saveAccount();
        // ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // AccountService accountService = (AccountService) ac.getBean("accountService");
        // accountService.saveAccount();
        // accountService.updateAccount(1);
        // accountService.deleteAccount();
    }

    @Test
    public void updateAccount() {
        accountService.updateAccount(1);
    }

    @Test
    public void deleteAccount() {
        accountService.deleteAccount();
    }
}