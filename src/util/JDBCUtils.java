package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <p>Name: JDBCUtils</p>
 * <p>Project: JDBC tutorial</p>
 * <p>Package: util</p>
 * <p>Description: JDBC自定义工具类</p>
 * <p>User: xiaolu</p>
 * <p>Date: 2022/10/15</p>
 * <p>Time: 23:17</p>
 * <p>Created with IntelliJ IDEA on macOS</p>
 * <p>To change this template use File | Settings | File Templates.</p>
 */
public class JDBCUtils {
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String database_url = "localhost:3306";
    public static String database_name = "JDBC_tutorial";
    public static String database_is_use_ssl = "false";
    public static String database_time_zone = "UTC";
    public static String url = "jdbc:mysql://" + database_url + "/" + database_name + "?useSSL=" + database_is_use_ssl + "&serverTimezone=" + database_time_zone;
    public static String username = "root";
    public static String password = "";

    public static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            throw new RuntimeException(e);
        }
        return connection;
    }

}
