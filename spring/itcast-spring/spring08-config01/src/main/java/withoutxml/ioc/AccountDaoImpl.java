package withoutxml.ioc;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
//@Component(value = "ad")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Account> findAllAccount() {
        List query = null;
        try {
            query = queryRunner.query("select * from account", new BeanListHandler<>(Account.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
}
