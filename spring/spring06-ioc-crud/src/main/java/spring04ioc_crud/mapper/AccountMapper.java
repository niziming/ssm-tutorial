package spring04ioc_crud.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AccountMapper {
    ResultSet getResult(String sql) throws SQLException, ClassNotFoundException;
}
