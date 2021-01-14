package spring02ioc.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring02ioc.dao.IAccountDao;
import spring02ioc.factory.InstanceFactory;
import spring02ioc.service.IAccountService;

import java.io.IOException;

// 测试
public class Client {
    public static void main(String[] args) throws IOException {
        //1.使用 ApplicationContext 接口，就是在获取 spring 容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取bean
        IAccountDao iad = (IAccountDao) ac.getBean("accountDao");
        iad.saveAccount();

        IAccountService ias = (IAccountService)ac.getBean("accountService");
        ias.saveAccount();

        IAccountService as = new InstanceFactory().createAS();
        as.saveAccount();
        System.out.printf("------------");
        //第二种方式：spring 管理静态工厂-使用静态工厂的方法创建对象
        IAccountService ac2 = (IAccountService) ac.getBean("ac2");
        System.out.printf("ac2");
        ac2.saveAccount();

        //第三种方式：spring 管理实例工厂-使用实例工厂的方法创建对象
        IAccountService accountService1 = (IAccountService) ac.getBean("accountService1");
        accountService1.saveAccount();

        //创建对象的时间点不一样。
        //ApplicationContext：只要一读取配置文件，默认情况下就会创建对象。
        //BeanFactory：什么使用什么时候创建对象。
        // 1.获取spring容器, 使用ApplicationContext接口

        //ClassPathXmlApplicationContext：
        //它是从类的根路径下加载配置文件 推荐使用这种
        //FileSystemXmlApplicationContext：
        //它是从磁盘路径上加载配置文件，配置文件可以在磁盘的任意位置。
        //AnnotationConfigApplicationContext:
        //当我们使用注解配置容器对象时，需要使用此类来创建 spring 容器。它用来读取注解。

        // File f = new File("bean.xml");
        // boolean exists = f.exists();
        // if (!exists) f.createNewFile();
        // System.out.println(exists);
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //// 2.根据bean的id获取对象
        //IAccountServiceImpl accountService = (IAccountServiceImpl) ac.getBean("accountService");
        //System.out.println(accountService);
        //accountService.saveAccount();
        //
        //// 获取dao
        //IAccountDao accountDao = (IAccountDao) ac.getBean("accountDao");
        //System.out.println(accountDao);
        //accountDao.saveAccount();

        //// 第二种获取方式
        //IAccountServiceFactory accountServiceFactory = (IAccountServiceFactory)ac.getBean("accountServiceFactory");
        //System.out.println(accountServiceFactory);
        //accountServiceFactory.saveAccount();
        //
        //// 第三种方式获取
        //IAccountService accountService1 = (IAccountService)ac.getBean("accountService");
        //accountService.saveAccount();
    }
}
