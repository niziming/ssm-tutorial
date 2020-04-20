package spring02ioc.factory;

import spring02ioc.service.IAccountServiceFactory;
import spring02ioc.service.impl.IAccountServiceImplFactory;

/**
 * 第二种方式：spring管理静态工厂-使用静态工厂的方法创建对象
 * 模拟一个静态工厂，创建业务层实现类
 */
public class StaticFactory {
    public static IAccountServiceFactory createAS() {
        return new IAccountServiceImplFactory();
    }

}
