package spring04ioc_crud.mapper.impl;

import org.springframework.stereotype.Component;
import spring04ioc_crud.mapper.AccountMapper;

import java.sql.*;

@Component(value = "accountMapper")
public class AccountMapperImpl implements AccountMapper {
    private Connection conn;
    String drvice;
    public AccountMapperImpl() throws SQLException, ClassNotFoundException {
        // Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/excercise?serverTimezone=GMT%2B8", "root", "root");
    }

    public ResultSet getResult(String sql) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/excercise?serverTimezone=GMT%2B8", "root", "root");
        // 3.获取预处理sql语句对象
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        return resultSet;
        // ResultSetMetaData metaData = resultSet.getMetaData();
        // int columnCount = metaData.getColumnCount();
        // while (resultSet.next()) {
        //     for (int i = 1; i < columnCount; i++) {
        //         System.out.print(resultSet.getString(i) + " ");
        //     }
        //     System.out.println();
        // }
        // 4.获取结果集
        // resultSet.close();
        // pstm.close();
        // conn.close();
        // 5.遍历结果集
    }

    public Connection getConn() {
        return conn;
    }
}
