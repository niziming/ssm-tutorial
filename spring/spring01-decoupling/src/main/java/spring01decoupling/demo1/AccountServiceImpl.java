package spring01decoupling.demo1;

import java.sql.*;

/**
 * 2.1.1.示例
 * 这段代码表示业务层调用持久层, 并且此时业务层在依赖持久层的接口和实现类.
 * 如果没有此时持久层实现类,编译不能通过.
 * 这种编译期依赖关系应该在我们开发中杜绝.
 *
 */
class AccountServiceImpl implements IAccountService {
    private IAccountService ad = new AccountServiceImpl();

    /**
     * 早期我们的JDBC操作，注册驱动时，
     * 我们为什么不使用DriverManager的register方法，
     * 而是采用Class.forName的方式？
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        // Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/excercise?serverTimezone=GMT%2B8", "root", "root");
        // 3.获取预处理sql语句对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        ResultSet resultSet = pstm.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (resultSet.next()){
            for (int i = 1; i < columnCount; i++) {
                System.out.print(resultSet.getString(i) + " ");
            }
            System.out.println();
        }
        // 4.获取结果集
        resultSet.close();
        pstm.close();
        conn.close();
        // 5.遍历结果集

        /**
         * 原因就是：我们的类依赖了数据库的具体驱动类（MySQL），
         * 如果这时候更换了数据库品牌（比如Oracle），
         * 需要修改源码来重新数据库驱动。这显然不是我们想要的。
         */

        /** 2.1.2当是我们讲解jdbc时，是通过反射来注册驱动的，
         * 代码如下：Class.forName("com.mysql.spring01decoupling.Driver");//此处只是一个字符串
         * 此时的好处是，我们的类中不再依赖具体的驱动类，此时就算删除mysql的驱动jar包，
         * 依然可以编译（运行就不要想了，没有驱动不可能运行成功的）。同时，也产生了一个新的问题，
         * mysql驱动的全限定类名字符串是在java类中写死的，一旦要改还是要修改源码。
         * 解决这个问题也很简单，使用配置文件配置。
         */

        /**
         * 2.1.3 工厂模式结构
         * 在实际开发中我们可以把三层的对象都使用配置文件配置起来，
         * 当启动服务器应用加载的时候，让一个类中的方法通过读取配置文件，
         * 把这些对象创建出来并存起来。在接下来的使用的时候，直接拿过来用就好了。
         * 那么，这个读取配置文件，创建和获取三层对象的类就是工厂。
         */
    }

}
