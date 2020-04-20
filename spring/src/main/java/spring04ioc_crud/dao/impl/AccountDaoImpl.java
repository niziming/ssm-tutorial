package spring04ioc_crud.dao.impl;

import spring04ioc_crud.dao.AccountDao;
import spring04ioc_crud.entity.Account;
import spring04ioc_crud.mapper.AccountMapper;
import spring04ioc_crud.mapper.impl.AccountMapperImpl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    AccountMapper accountMapper;

    public AccountDaoImpl() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void save(Account a) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = accountMapper.getResult("select * from account");
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i < columnCount; i++) {
                System.out.print(resultSet.getString(i) + " ");
            }
            System.out.println();
        }
    }

    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public void update(Account a) {

    }

    @Override
    public void del(Account a) {

    }

    @Override
    public void findById(Account a) {

    }

    @Override
    public List<Account> findAll() {
        return null;
    }
}
