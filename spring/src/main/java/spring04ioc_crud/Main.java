package spring04ioc_crud;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring04ioc_crud.mapper.AccountMapper;
import spring04ioc_crud.service.AccountService;
import spring04ioc_crud.service.impl.AccountServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        method();
    }

    public static void method() throws SQLException, ClassNotFoundException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountServiceCrud");
        accountService.getAll();

    }

}
