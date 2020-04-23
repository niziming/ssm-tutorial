package spring06_anno_ioc.dao.impl;

import org.springframework.stereotype.Repository;
import spring06_anno_ioc.dao.AccountDao;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户1111111111111");
    }
}
