package withoutxml.ioc;

import withoutxml.config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        //通过注解获取容器：
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        DataSource dataSource = ac.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = applicationContext.getBean("accountServiceImpl", AccountService.class);
        List<Account> allAccount = as.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }
}
