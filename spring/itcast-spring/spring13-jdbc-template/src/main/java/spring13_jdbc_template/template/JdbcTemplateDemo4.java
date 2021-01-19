package spring13_jdbc_template.template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring13_jdbc_template.dao.AccountDao;
import spring13_jdbc_template.domain.Account;

/**
 * JdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo4 {

    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);

        Account account = accountDao.findAccountById(1);
        System.out.println(account);

        // account.setMoney(30000f);
        // accountDao.updateAccount(account);
    }
}
