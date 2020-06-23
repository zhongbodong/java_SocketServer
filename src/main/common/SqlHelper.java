package main.common;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlHelper implements ISqlHelper {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://111.229.198.31:3306/BL?useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "123456";

   /* String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//设置SQL Server数据库引擎
    String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=BLTest";//指定数据库
    String user = "sa";
    String password = "topsky";//登陆密码*/
    public SqlHelper()
    {
        getSqlDriver();
        getConnection();

    }
    //加载数据库引擎
public void  getSqlDriver()
{

    try {
        //Class.forName(JDriver);//加载数据库引擎
        // 注册 JDBC 驱动
        Class.forName(JDBC_DRIVER);

        // 打开链接
        //System.out.println("连接数据库...");

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.exit(0);
    }
}

public Connection getConnection()
{
    try {

        //Connection con = DriverManager.getConnection(connectDB, user, password);//连接数据库
        Connection  conn = DriverManager.getConnection(DB_URL,USER,PASS);
        System.out.println("connect success");
        return conn;


    } catch (SQLException e) {
        e.printStackTrace();
        System.exit(0);
        return null;
    }


}






//插入数据到数据库
    @Override
    public int Insert(String sql) {
        SqlHelper sqlHelper=new  SqlHelper();
        Connection con= sqlHelper.getConnection();
        Statement statement = null;
        try {
            statement = con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String insert1 =sql; //"INSERT INTO SensorInformation VALUES('0001','86354726')";
        try {
            statement.executeUpdate(insert1);
            statement.close();//关闭命令对象连接
            con.close();//关闭数据库连接
            System.out.println("insert success");
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }


    }
}
