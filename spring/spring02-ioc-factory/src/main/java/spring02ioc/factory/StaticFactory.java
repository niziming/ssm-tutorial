package spring02ioc.factory;

import spring02ioc.service.IAccountService;
import spring02ioc.service.impl.IAccountServiceImpl;

public class StaticFactory {
    public static IAccountService crAS () {
        return new IAccountServiceImpl();
    }
}
