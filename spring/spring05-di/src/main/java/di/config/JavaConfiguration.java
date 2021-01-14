package di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import di.DISet.IAS;
import di.DISet.impl.IASImpl;

import java.util.List;

/*
 使用Java配置类注入DI
 */
@Configuration
public class JavaConfiguration {
    @Bean
    public IAS getAccount1(){
        IASImpl ias = new IASImpl();
        String[] str = {"hello", "hello1"};
        ias.setMyList(List.<String>of(str));
        return ias;
    }
}
