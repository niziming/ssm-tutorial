package spring06_anno_ioc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring06_anno_ioc.dao.AccountDao;
import spring06_anno_ioc.service.AccountService;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    // @Qualifier(value = "accountDao1")
    @Autowired
    // @Resource(name = "accountDao")
    private AccountDao accountDao1;
    @Autowired
    private AccountDao accountDao;
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
    @Override
    public void saveAccount1() {
        accountDao1.saveAccount();
    }
}
