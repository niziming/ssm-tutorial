package aop.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 和spring连接数据库相关的配置类
 */
public class JdbcConfig {
    /**
     * @Value 作用：
     * 注入基本数据类型和 String 类型数据的
     * 属性：
     * value：用于指定值
     */
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 创建queryRunner对象
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "queryRunner")
    public QueryRunner createQueryRunner(@Qualifier("dataSource") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据对象
     * @return
     *
     * @Bean
     * 作用：
     * 该注解只能写在方法上，表明使用此方法创建一个对象，并且放入 spring 容器。
     * 属性：
     * name：给当前@Bean 注解方法创建的对象指定一个名称(即 bean 的 id）。
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass(driver);
            cpds.setJdbcUrl(url);
            cpds.setUser(username);
            cpds.setPassword(password);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return cpds;
    }
}
