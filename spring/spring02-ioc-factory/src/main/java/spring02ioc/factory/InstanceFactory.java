package spring02ioc.factory;

import spring02ioc.service.IAccountService;
import spring02ioc.service.impl.IAccountServiceImpl;

/**
 * 模拟一个实例工厂，创建业务层实现类* 此工厂创建对象，必须现有工厂实例对象，再调用方法
 */
public class InstanceFactory {
    public IAccountService creatAS(){
        return new IAccountServiceImpl();
    }
}
