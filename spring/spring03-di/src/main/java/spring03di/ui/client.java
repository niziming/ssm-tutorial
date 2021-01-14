package spring03di.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring03di.DISet.IAS;
import spring03di.DISet.impl.IASImpl;
import spring03di.service.AccountService;

public class client {
    public static void main(String[] args) {
        // 使用Java配置类注入DI
        // AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        // IAS bean = annotationConfigApplicationContext.getBean(IAS.class);
        // bean.saveAccount();
        method();
    }

    public static void method() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = (AccountService) ac.getBean("as");
        System.out.println("as");
        as.saveAccount();

        AccountService as1 = (AccountService) ac.getBean("as1");
        System.out.println("as1");
        as1.saveAccount();

        AccountService as2 = (AccountService) ac.getBean("as2");
        System.out.println("as2");
        as2.saveAccount();

        IAS as3 = (IAS) ac.getBean("as3");
        System.out.println("as3");
        as3.saveAccount();

    }

}
