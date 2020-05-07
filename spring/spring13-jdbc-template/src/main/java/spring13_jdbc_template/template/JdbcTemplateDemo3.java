package spring13_jdbc_template.template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate的CRUD操作
 */
public class JdbcTemplateDemo3 {
    private void insertUser(){
        // 1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        // 3.执行
        // 3.1新增
        // jt.execute("insert into account(name,money)values('ddd',2222)");
        // 3.2更新
        // jt.update("update account set name=?,money=? where id=?","test",4567,9);
        // 3.3删除
        // jt.update("delete from account where id=?",8);
        // 3.4查询所有
        // List<Account> query = jt.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        // System.out.println(query);
        // 3.5 查询一行一列
        // Long aLong = jt.queryForObject("select count(*) from account where money > ?", Long.class, 1000f);
        // System.out.println(aLong);
    }
    public static void main(String[] args) {
        new JdbcTemplateDemo3().insertUser();
    }

}
