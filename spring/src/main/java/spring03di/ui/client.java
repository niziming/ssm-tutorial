package spring03di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring03di.DIList.IAS;
import spring03di.DIList.impl.IASImpl;
import spring03di.config.JavaConfiguration;
import spring03di.service.AccountService;

public class client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        IAS bean = annotationConfigApplicationContext.getBean(IAS.class);
        bean.saveAccount();
        // method();
    }

    public static void method() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = (AccountService) ac.getBean("account");
        as.saveAccount();

        AccountService as1 = (AccountService)ac.getBean("accountSet");
        as1.saveAccount();

        AccountService as2 = (AccountService)ac.getBean("accountNamespace");
        as2.saveAccount();

        IAS ias = (IAS)ac.getBean("DIListAccount");
        ias.saveAccount();

    }

}
