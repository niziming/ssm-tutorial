package spring06_anno_ioc.dao.impl;

import org.springframework.stereotype.Repository;
import spring06_anno_ioc.dao.AccountDao;

@Repository("accountDao1")
public class AccountDaoImpl1 implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户22222");
    }
}
