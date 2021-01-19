package withoutxml.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("withoutxml")
// Import用于导入其他配置类，在引入其他配置类时，可以不用再写@Configuration 注解。当然，写上也没问题。
@Import({ JdbcConfig.class })
@PropertySource("classpath:config.properties")
public class SpringConfiguration {
}
