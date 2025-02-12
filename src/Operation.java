import  java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import Database.*;

public class Operation {

    //Method to Add New Student in Database.Database
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getGrade());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }


    //Method to Retrieve all Students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet result = stmt.executeQuery(query))
        {

            while(result.next()){
                Student student = new Student(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("age"),
                        result.getString("grade")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            throw new RuntimeException(e);
        }
        return students;
    }

    //Update Student Details
    public void updateStudent(int id, String name, int age, String grade)
    {
        String query = "UPDATE students SET name=?, age=?, grade=?  WHERE id=?";
        try(Connection connect = Database.getConnection();
            PreparedStatement preparedStatement = connect.prepareStatement(query))
        {
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,age);
            preparedStatement.setString(3,grade);
            preparedStatement.setInt(4,id);

            int rowUpdated = preparedStatement.executeUpdate();
            if(rowUpdated>0)
            {
                System.out.println("Student Updated Successfully!");
            }
            else
            {
                System.out.println("No Student found with Id : "+ id);
            }
        }
        catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    //Delete Student from Database
    public void deleteStudent(int id)
    {
        String query = "DELETE FROM students WHERE id=?";
        try(Connection connect = Database.getConnection();
            PreparedStatement preparedStatement = connect.prepareStatement(query))
        {
            preparedStatement.setInt(1,id);
            int rowDeleted = preparedStatement.executeUpdate();
            if(rowDeleted>0)
            {
                System.out.println("Student Deleted Successfully!");
            }
            else
            {
                System.out.println("No Student found with Id : "+ id);
            }
        }
        catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
