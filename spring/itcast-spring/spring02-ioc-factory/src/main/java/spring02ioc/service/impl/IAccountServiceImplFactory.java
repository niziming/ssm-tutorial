package spring02ioc.service.impl;

import spring02ioc.dao.IAccountDao;
import spring02ioc.dao.impl.AccountDaoImpl;
import spring02ioc.service.IAccountService;
import spring02ioc.service.IAccountServiceFactory;

/**
 * 3.1.2创建业务层接口和实现类
 */
public class IAccountServiceImplFactory implements IAccountServiceFactory {
    // 此处的依赖关系有待解决
    private IAccountDao as = new AccountDaoImpl();
    public void saveAccount() {
        System.out.println("开始存Account");
        as.saveAccount();
    }
}
