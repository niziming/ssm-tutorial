package spring02ioc.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring01decoupling.IAccountService;
import spring02ioc.dao.IAccountDao;
import spring02ioc.service.IAccountServiceFactory;
import spring02ioc.service.impl.IAccountServiceImpl;

import java.io.IOException;

// 测试
public class Client {
    public static void main(String[] args) throws IOException {
        // 1.获取spring容器, 使用ApplicationContext接口
        // File f = new File("bean.xml");
        // boolean exists = f.exists();
        // if (!exists) f.createNewFile();
        // System.out.println(exists);
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.根据bean的id获取对象
        IAccountServiceImpl accountService = (IAccountServiceImpl) ac.getBean("accountService");
        System.out.println(accountService);
        accountService.saveAccount();

        // 获取dao
        IAccountDao accountDao = (IAccountDao) ac.getBean("accountDao");
        System.out.println(accountDao);
        accountDao.saveAccount();

        // 第二种获取方式
        IAccountServiceFactory accountServiceFactory = (IAccountServiceFactory)ac.getBean("accountServiceFactory");
        System.out.println(accountServiceFactory);
        accountServiceFactory.saveAccount();

        // 第三种方式获取
        IAccountService accountService1 = (IAccountService)ac.getBean("accountService");
        accountService.saveAccount();
    }
}
