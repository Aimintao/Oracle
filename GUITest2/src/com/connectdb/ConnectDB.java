package com.connectdb;

import com.user.UserInfo;
import java.sql.*;

public class ConnectDB {
    /**
     * 获取数据库连接
     * @return Connection对象
     */
    private static   String server;
    private static String userName;
    private static String passwd;

    public static void init(UserInfo user){
        server=user.getServer();
        userName=user.getUsrName();
        passwd=user.getPasswd();
    }

    public static Connection getConnection(){
        Connection conn=null;
        String driver = "oracle.jdbc.driver.OracleDriver";
        //String url = "jdbc:Oracle:thin:@localhost:1521:orcl";
        String url2="jdbc:Oracle:thin:@localhost:1521:";
        url2=url2+server;
        try {
            // 加载驱动
            Class.forName(driver);
            // 获取数据库连接
            //conn=DriverManager.getConnection(url,"CHAN","******");
            conn=DriverManager.getConnection(url2,userName,passwd);
            System.out.println("数据库连接成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 关闭数据库连接
     * @param conn Connection对象
     */
    public static void closeConnection(Connection conn){
        // 判断conn是否为空
        if(conn != null){
            try {
                conn.close();	// 关闭数据库连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
