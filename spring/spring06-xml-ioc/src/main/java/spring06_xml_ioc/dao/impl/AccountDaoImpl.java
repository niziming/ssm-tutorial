package spring06_xml_ioc.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import spring06_xml_ioc.dao.AccountDao;
import spring06_xml_ioc.domain.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private QueryRunner queryRunner;
    @Override
    public List<Account> findAllAccount() {
        List<Account> query = null;
        try {
            query = queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询所有账户错误 - AccountDao.findAllAccount");
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
    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

}
