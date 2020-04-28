package spring09_aop_account.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接的工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的链接
     */
    public Connection getThreadConnection(){
        // ThreadLocal上获取
        Connection connection = t1.get();
        // 判断线程是否有连接
        if (connection == null){
            //3.从数据源中获取一个连接，并且存入ThreadLocal中
            try {
                connection = dataSource.getConnection();
                t1.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 返回当前线程上的链接
        return connection;
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection () {
        t1.remove();
    }
}
