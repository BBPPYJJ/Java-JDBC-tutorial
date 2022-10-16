package bean;

import util.JDBCUtils;

/**
 * <p>Name: Student</p>
 * <p>Project: JDBC tutorial</p>
 * <p>Package: bean</p>
 * <p>Description: 定义记录的类（可选，主要是为了便于操作和接口定义）</p>
 * <p>User: xiaolu</p>
 * <p>Date: 2022/10/15</p>
 * <p>Time: 23:15</p>
 * <p>Created with IntelliJ IDEA on macOS</p>
 * <p>To change this template use File | Settings | File Templates.</p>
 */
public class Student {
    private String Id;
    private String Name;
    private String Sex;
    private String Age;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public Student(String name, String sex, String age) {
        Name = name;
        Sex = sex;
        Age = age;
    }
}
