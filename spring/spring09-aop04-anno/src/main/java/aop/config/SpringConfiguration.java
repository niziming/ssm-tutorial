package aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("aop")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
// 开启 spring 对注解 AOP 的支持 对应标签<aop:aspectj-autoproxy/>
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
