package spring04ioc_crud.dao;

import spring04ioc_crud.entity.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    void save(Account a) throws SQLException, ClassNotFoundException;
    void update(Account a);
    void del(Account a);
    void findById(Account a);
    List<Account> findAll();
}
