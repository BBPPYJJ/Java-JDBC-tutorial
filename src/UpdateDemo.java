import bean.Student;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <p>Name: UpdateDemo</p>
 * <p>Project: JDBC tutorial</p>
 * <p>Package: PACKAGE_NAME</p>
 * <p>Description: Update demo</p>
 * <p>User: xiaolu</p>
 * <p>Date: 2022/10/16</p>
 * <p>Time: 16:55</p>
 * <p>Created with IntelliJ IDEA on macOS</p>
 * <p>To change this template use File | Settings | File Templates.</p>
 */
public class UpdateDemo {
    public static void update(Student student) {
        System.out.println("==========更新==========");
        Connection connection = JDBCUtils.getConnection();
        int i = 0;
        //language=MySQL
        String sql = "UPDATE students SET Age='" + student.getAge() + "' WHERE Name='" + student.getName() + "'";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            i = preparedStatement.executeUpdate();
            System.out.println("sql: " + preparedStatement.toString());
            System.out.println("修改了" + i + "行");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("更新失败");
            throw new RuntimeException(e);
        }
        System.out.println("==========更新结束==========");
    }
}
