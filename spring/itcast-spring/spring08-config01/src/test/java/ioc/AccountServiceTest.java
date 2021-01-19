package ioc;

import withoutxml.config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import withoutxml.ioc.Account;
import withoutxml.ioc.AccountService;

import java.util.List;

//Spring 整合 Junit
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration 注解：
// locations 属性：用于指定配置文件的位置。如果是类路径下，需要用 classpath:表明
// classes 属性：用于指定注解的类。当不使用 xml 配置时，需要用此属性指定注解类的位置。
//@ContextConfiguration(locations = {"classpath:bean.xml"})
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    AccountService accountService;
    @Test
    public void findAllAccount() {
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }
}