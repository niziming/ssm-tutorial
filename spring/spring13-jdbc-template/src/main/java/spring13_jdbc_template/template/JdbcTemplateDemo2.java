package spring13_jdbc_template.template;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcTemplate基本用法
 */
public class JdbcTemplateDemo2 {
    public void insertUser(){
        // 获取容器
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = classPathXmlApplicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        jdbcTemplate.execute("insert into account(name,money)values('ddd',2222)");
    }
    public static void main(String[] args) {
        new JdbcTemplateDemo2().insertUser();
    }

}
