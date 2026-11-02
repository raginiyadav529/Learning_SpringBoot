package com.ragini.repo;

import com.ragini.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {


    String url = "jdbc:mysql://localhost:3306/Student_DB";
    String user = "root";
    String password = "Ragini@123";

    public void createStudent(Student student) {

        String sql = """
                         INSERT INTO students(name , email ,age)
                         VALUES(?,?,?)
                         
                         """
                ;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ){
            System.out.println("Database Connected Successfully ! ");

            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setInt(3,student.getAge());

            int rowAffected  = preparedStatement.executeUpdate();

            if (rowAffected == 0) {

                System.out.println("Student not created  !");
            }
            else {

                System.out.println("Student created successfully!");
            }
        }
        catch (
                SQLException e) {
            System.out.println("Database Connection failed ! ");
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student ,int id) {

        String sql = """
                         UPDATE students SET name =? ,
                         email =? ,
                         age = ?
                         WHERE id = ?
                         
                         """
                ;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ){
            System.out.println("Database Connected Successfully ! ");

            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setInt(4,id);

            int rowAffected  = preparedStatement.executeUpdate();

            if (rowAffected == 0) {

                System.out.println("Student not updated !");
            }
            else {

                System.out.println("Student updated successfully!");
            }
        }
        catch (
                SQLException e) {
            System.out.println("Database Connection failed ! ");
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {

        String sql = """
                         DELETE FROM students
                         WHERE id =?
                         
                         """ ;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ){
            System.out.println("Database Connected Successfully ! ");

            preparedStatement.setInt(1,id);

            int rowAffected  = preparedStatement.executeUpdate();

            if (rowAffected == 0) {

                System.out.println("Student not deleted !");
            }
            else {

                System.out.println("Student deleted successfully!");
            }
        }
        catch (
                SQLException e) {
            System.out.println("Database Connection failed ! ");
            e.printStackTrace();
        }
    }

    public Student getStudentById(int id) {

        Student student = null ;

        String sql = """
                         SELECT id , name , email ,age FROM students
                         WHERE id =?
                         
                         """ ;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ){
            System.out.println("Database Connected Successfully ! ");

            preparedStatement.setInt(1,id);

            try(ResultSet resultSet = preparedStatement.executeQuery()){

                if(resultSet.next()){

                    student = mapRow(resultSet);
                    System.out.println(student);
                }
            }
        }
        catch (
                SQLException e) {
            System.out.println("Database Connection failed ! ");
            e.printStackTrace();
        }
        return student;
    }

    private Student mapRow(ResultSet resultSet) throws SQLException {

        Student student = new Student();

        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }

    public List<Student> getAllStudents() {

        String sql = """
                         SELECT id , name , email , age  FROM students
                        
                         
                         """ ;

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement( sql );

        ){
            System.out.println("Database Connected Successfully ! ");

            try(ResultSet resultSet = preparedStatement.executeQuery()){

                List<Student> studentList = new ArrayList<>();

                while (resultSet.next()){

                    Student student = mapRow(resultSet);
                    studentList.add(student);
                    System.out.println(student);
                }
                return studentList ;
            }
        }
        catch (
                SQLException e) {
            System.out.println("Database Connection failed ! ");
            e.printStackTrace();
            return List.of();
        }
    }
}
