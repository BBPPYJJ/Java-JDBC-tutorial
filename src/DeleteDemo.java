import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <p>Name: DeleteDemo</p>
 * <p>Project: JDBC tutorial</p>
 * <p>Package: PACKAGE_NAME</p>
 * <p>Description: Delete demo</p>
 * <p>User: xiaolu</p>
 * <p>Date: 2022/10/16</p>
 * <p>Time: 18:03</p>
 * <p>Created with IntelliJ IDEA on macOS</p>
 * <p>To change this template use File | Settings | File Templates.</p>
 */
public class DeleteDemo {
    public static int delete(String name) {
        System.out.println("==========删除==========");
        Connection connection = JDBCUtils.getConnection();
        int i = 0;
        //language=MySQL
        String sql = "DELETE FROM students WHERE Name='" + name + "'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            i = preparedStatement.executeUpdate();
            System.out.println("删除了" + i + "行");
            System.out.println("sql: " + preparedStatement.toString());
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("删除失败");
            throw new RuntimeException(e);
        }
        System.out.println("==========删除结束==========");
        return i;
    }
}
