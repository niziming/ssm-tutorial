package spring08_anno_ioc_withoutxml.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("spring08_anno_ioc_withoutxml")
@Import(JdbcConfig.class)
@PropertySource("jdbcConfig.properties")
public class SpringConfiguration {
}
