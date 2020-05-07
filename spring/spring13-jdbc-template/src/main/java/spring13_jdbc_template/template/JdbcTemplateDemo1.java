package spring13_jdbc_template.template;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcTemplate基本用法
 */
public class JdbcTemplateDemo1 {

    public void insertUser(){
        // 准备数据源：spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/excercise?serverTimezone=UTC");
        ds.setUser("root");
        ds.setPassword("root");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        jdbcTemplate.execute("insert into account(name,money)values('ccc',1000)");
    }
    public static void main(String[] args) {
        new JdbcTemplateDemo1().insertUser();
    }

}
