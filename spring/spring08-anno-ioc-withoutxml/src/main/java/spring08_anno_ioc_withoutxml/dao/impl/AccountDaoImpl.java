package spring08_anno_ioc_withoutxml.dao.impl;

import spring08_anno_ioc_withoutxml.dao.AccountDao;
import spring08_anno_ioc_withoutxml.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner queryRunner;

    @Override
    public List<Account> findAllAccount() {
        List<Account> query = null;
        try {
             query = queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
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
