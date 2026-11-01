package com.jdbc2.repo;

import com.jdbc2.model.Student;
import java.sql.*;

                                                    /******   Using Statement  ********/
public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/Student_DB";
    String user = "root";
    String password = "Ragini@123";

    public void createUser() {

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected Successfully ! ");

            Statement statement = connection.createStatement();
            String sql ="INSERT INTO students(name ,email, age) " +
                    "VALUES('Mamta','mamata@gmail.com',24)";

          int result = statement.executeUpdate(sql);
          if(result == 0){

              System.out.println("User not created , Operation Failed !");
          }
          else {

              System.out.println("User created , Operation Successful !");
          }
          connection.close();
          statement.close();
        }
        catch (
                SQLException e) {
            System.out.println("Database Connection failed ! ");
            e.printStackTrace();
        }
    }

    public void updateUser(){

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected Successfully ! ");

            Statement statement = connection.createStatement();
            String sql ="UPDATE students SET age = 21 " +
                    "WHERE id = 1";

            int result = statement.executeUpdate(sql);
            if(result == 0){

                System.out.println("User not updated ,Operation Failed !");
            }
            else {

                System.out.println("User updated ,Operation Successful !");
            }
            connection.close();
            statement.close();
        }
        catch (
                SQLException e) {
            System.out.println("Database Connection failed ! ");
            e.printStackTrace();
        }
    }

    public void deleteUser(){

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected Successfully ! ");

            Statement statement = connection.createStatement();
            String sql ="DELETE FROM students " +
                    "WHERE id = 1";

            int result = statement.executeUpdate(sql);
            if(result == 0){

                System.out.println("Deletion Failed !");
            }
            else {

                System.out.println("Deletion Successful !");
            }
            connection.close();
            statement.close();
        }
        catch (
                SQLException e) {
            System.out.println("Database Connection failed ! ");
            e.printStackTrace();
        }
    }

    public void getUserById(){

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected Successfully ! ");

            Statement statement = connection.createStatement();
            String sql ="SELECT * FROM students WHERE id = 2";

            ResultSet resultSet = statement.executeQuery(sql);
           resultSet.next();

            Student student = mapRow(resultSet);

            System.out.println(student);

            connection.close();
            statement.close();
        }
        catch (
                SQLException e) {
            System.out.println("Database Connection failed ! ");
            e.printStackTrace();
        }
    }

    private Student mapRow(ResultSet resultSet) throws SQLException {

        Student student = new Student();

        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));
        return student;

    }

    public void completeCRUD(){

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected Successfully ! ");

            Statement statement = connection.createStatement();

            String sql ="INSERT INTO students(name , email, age)" +
                    "VALUES('Rina','rina@123',27)";

            boolean result = statement.execute(sql);
            if(result){  // select --> true

                ResultSet rs = statement.getResultSet();

                System.out.println("Select query executed !");

                while (rs.next()){

                    System.out.println(rs.getInt("id"+"  ")+
                            rs.getInt("age"+"  ")+
                            rs.getString("name"+"  ")+
                            rs.getString("email"+"  ")
                    );
                }
            }
            else {

                System.out.println("Update query executed !");
              int rowAffected = statement.getUpdateCount();

              if(rowAffected == 0){

                  System.out.println("Operation failed !");
              }
              else{
                  System.out.println("Operation successful !");
              }

            }
            connection.close();
            statement.close();
        }
        catch (
                SQLException e) {
            System.out.println("Database Connection failed ! ");
            e.printStackTrace();
        }

    }


}
