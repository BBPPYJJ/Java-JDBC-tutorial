import bean.Student;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try {
            InsertDemo.insert(new Student("xiaolu", "男", "18"));
            UpdateDemo.update(new Student("xiaolu", "", "21"));
            SelectDemo.select();
            DeleteDemo.delete("xiaolu");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}