package aop.dao.impl;

import aop.domain.Account;
import aop.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import aop.utils.ConnectionUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements AccountDao {
    private QueryRunner queryRunner;
    private ConnectionUtils connectionUtils;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    @Override
    public List<Account> findAllAccount() {
        List<Account> query = null;
        try {
            query = queryRunner.query(connectionUtils.getThreadConnection(), "select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
