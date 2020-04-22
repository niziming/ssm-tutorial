package spring06_xml_ioc.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import spring06_xml_ioc.dao.AccountDao;
import spring06_xml_ioc.domain.Account;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private QueryRunner queryRunner;
    @Override
    public List<Account> findAllAccount() {
        return null;
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
