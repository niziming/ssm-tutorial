package spring02ioc.factory;

import spring02ioc.service.IAccountService;
import spring02ioc.service.impl.IAccountServiceImpl;

public class InstanceFactory {
    public IAccountService createAS() {
        //return () -> {};
        return new IAccountServiceImpl();
    }
}
