package withoutxml.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;


//他们三个注解都是针对一个的衍生注解，他们的作用及属性都是一模一样的。
//        他们只不过是提供了更加明确的语义化。
//@Controller：一般用于表现层的注解。
//@Service：一般用于业务层的注解。
//@Repository：一般用于持久层的注解。
@Service
@Scope(value = "singleton")// 指定 bean 的作用范围。
//@Component(value = "as")
public class AccountServiceImpl implements AccountService {
    @Value("hello123") // 注入基本数据类型和 String 类型数据的
    String hello;
    //@Qualifier(value = "accountDaoImpl")// 指定id注入
    //@Autowired // 相当于<property name="" ref="">set 方法可以省略。自动按照类型注入
    @Resource // 直接按照bean的ID注入, 也可以注入其他bean
    private AccountDao accountDao;
    //
    //public void setAccountDao(AccountDao accountDao) {
    //    this.accountDao = accountDao;
    //}
    public AccountServiceImpl () {
    }
    @PostConstruct //用于指定初始化方法。
    public void init (){
        System.out.println("初始化");
    }
    @PreDestroy //用于指定销毁方法。
    public void destroy (){
        System.out.println("销毁了");
    }
    @Override
    public List<Account> findAllAccount() {
        System.out.println(hello);
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return null;
    }

    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(Integer acccountId) {

    }
}
