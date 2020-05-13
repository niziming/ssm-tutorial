package spring15_aop_transaction_anno_withoutxml.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.Transactional;

/**
 * spring的配置类，相当于bean.xml
 */
@Configuration
@ComponentScan("spring15_aop_transaction_anno_withoutxml")
@Import({JdbcConfig.class, TransactionConfig.class})
@PropertySource("jdbcConfig.properties")
public class SpringConfiguration {
}
