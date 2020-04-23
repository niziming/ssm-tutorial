package spring04ioc_crud.service;

import java.sql.SQLException;

public interface AccountService {
    void getAll() throws SQLException, ClassNotFoundException;
}
