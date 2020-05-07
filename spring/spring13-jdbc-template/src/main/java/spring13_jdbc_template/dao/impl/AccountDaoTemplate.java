package spring13_jdbc_template.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import spring13_jdbc_template.dao.AccountDao;
import spring13_jdbc_template.domain.Account;

import java.util.List;

// @Repository
public class AccountDaoTemplate extends JdbcDaoSupport implements AccountDao {
    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        return null;
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public List<Account> findAccountAll() {
        return null;
    }

}
