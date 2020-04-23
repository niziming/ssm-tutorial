package spring06_xml_ioc.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring06_xml_ioc.domain.Account;
import spring06_xml_ioc.service.AccountService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceImplTest {
    @Autowired
    private AccountService accountService;

    @PostConstruct
    public void init(){
        System.out.println("测试方法开始执行");
    }
    @PreDestroy
    public void destory(){
        System.out.println("测试结束");
        findAllAccount();
    }

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

    @Test
    public void saveAccount() {
        accountService.saveAccount(new Account("tom", 2000.0F));
    }

    @Test
    public void updateAccount() {
        accountService.updateAccount(new Account(1, "tony", 1100.0F));
    }

    @Test
    public void deleteAccount() {
        findAllAccount();
        accountService.deleteAccount(5);
        findAllAccount();
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
}