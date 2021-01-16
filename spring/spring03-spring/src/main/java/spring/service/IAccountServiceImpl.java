package spring.service;

import spring.dao.IAccountDao;
import spring.dao.IAccountDaoImpl;

public class IAccountServiceImpl implements IAccountService {
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    private IAccountDao accountDao;
    public IAccountServiceImpl(){
        System.out.println("对象创建了");
    }
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
