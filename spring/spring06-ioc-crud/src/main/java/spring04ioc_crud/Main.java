package spring04ioc_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring04ioc_crud.service.AccountService;

import java.sql.SQLException;

public class Main {
    @Autowired
    AccountService accountService;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        method();
        // method1();
    }

    private static void method1() {
        try {
            new Main().accountService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringA);
        // annotationConfigApplicationContext.getBean()
    }

    public static void method() throws SQLException, ClassNotFoundException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        accountService.getAll();

    }

}
