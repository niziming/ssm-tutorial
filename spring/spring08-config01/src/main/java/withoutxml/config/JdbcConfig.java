package withoutxml.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.Url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //2.5.2.3 @Bean
    //作用：该注解只能写在方法上，表明使用此方法创建一个对象，并且放入 spring 容器。
    //属性：name：给当前@Bean 注解方法创建的对象指定一个名称(即 bean 的 id）。
    @Bean
    public DataSource dataSource () {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Bean(name = "queryRunner")
    public QueryRunner createQueryRunner (@Qualifier("dataSource") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }
}
