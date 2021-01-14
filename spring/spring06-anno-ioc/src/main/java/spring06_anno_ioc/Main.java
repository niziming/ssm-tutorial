package spring06_anno_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring06_anno_ioc.service.AccountService;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // bean.xml加入扫描
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.saveAccount();
        accountService.saveAccount1();
    }
}
