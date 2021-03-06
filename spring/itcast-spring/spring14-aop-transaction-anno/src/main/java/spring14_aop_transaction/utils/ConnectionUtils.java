package spring14_aop_transaction.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
 */
@Component
public class ConnectionUtils {
    private ThreadLocal<Connection> tlc = new ThreadLocal<>();
    @Autowired
    private DataSource dataSource;

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection (){
        //1.先从ThreadLocal上获取
        Connection connection = tlc.get();
        try {
            //2.判断当前线程上是否有连接
            if (connection == null) {
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                connection = dataSource.getConnection();
                tlc.set(connection);
            }
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
        //4.返回当前线程上的连接
        return connection;
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tlc.remove();
    }
}
