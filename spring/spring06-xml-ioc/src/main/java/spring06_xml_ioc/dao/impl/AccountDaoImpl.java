package spring06_xml_ioc.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
        try{
            return queryRunner.query("select * from account where id = ? ",new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            queryRunner.update("insert into account(name,money)values(?,?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            queryRunner.update("update account set name=?, money=? where id=?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        try {
            queryRunner.update("delete from account where id=?", acccountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

}
