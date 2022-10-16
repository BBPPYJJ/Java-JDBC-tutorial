import bean.Student;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <p>Name: InsertDemo</p>
 * <p>Project: JDBC tutorial</p>
 * <p>Package: PACKAGE_NAME</p>
 * <p>Description: Insert demo</p>
 * <p>User: xiaolu</p>
 * <p>Date: 2022/10/16</p>
 * <p>Time: 15:50</p>
 * <p>Created with IntelliJ IDEA on macOS</p>
 * <p>To change this template use File | Settings | File Templates.</p>
 */
public class InsertDemo {
    public static int insert(Student student) {
        System.out.println("==========插入==========");
        Connection connection = JDBCUtils.getConnection();
        int i = 0;
        //language=MySQL
        String sql = "INSERT INTO students (Name,Sex,Age) values (?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSex());
            preparedStatement.setString(3, student.getAge());
            System.out.println("sql: " + preparedStatement.toString());
            System.out.println("修改了" + preparedStatement.executeUpdate() + "行");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("插入失败");
            throw new RuntimeException(e);
        }
        System.out.println("==========插入结束==========");
        return i;
    }
}
