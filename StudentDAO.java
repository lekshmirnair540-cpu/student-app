import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Insert Student
    public void insertStudent(Student s) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO students(name, age, course) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getCourse());

            ps.executeUpdate();
            System.out.println("Student Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM students";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course")
                );
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Update Student
    public void updateStudent(int id, String name) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE students SET name=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Student Updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "DELETE FROM students WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Student Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}