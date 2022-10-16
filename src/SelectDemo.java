import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>Name: SelectDemo</p>
 * <p>Project: JDBC tutorial</p>
 * <p>Package: PACKAGE_NAME</p>
 * <p>Description: Select demo</p>
 * <p>User: xiaolu</p>
 * <p>Date: 2022/10/16</p>
 * <p>Time: 17:12</p>
 * <p>Created with IntelliJ IDEA on macOS</p>
 * <p>To change this template use File | Settings | File Templates.</p>
 */
public class SelectDemo {
    public static Integer select() {
        System.out.println("==========查询==========");
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from students";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            int columnCount = preparedStatement.getMetaData().getColumnCount();
            System.out.println("查询到" + columnCount + "列");
            while (resultSet.next()) {
                for (int i = 1; i < columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                    if ((i == 2) && (resultSet.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
        } catch (SQLException e) {
            System.out.println("选择失败");
            throw new RuntimeException(e);
        }
        System.out.println("==========查询结束==========");
        return null;
    }
}
