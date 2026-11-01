package com.telusko;

import java.sql.*;

public class Main2 {

    public static void main(String[] args)  {

            // Create connection
        Connection connection =null;
        Statement statement =null;

         try {

             String url = "jdbc:mysql://localhost:3306/JDBC1";
             String user = "root";
             String password = "Ragini@123";


             connection = DriverManager.getConnection(url, user, password);

             //Establishing Statement

             statement = connection.createStatement();

             // Process the result

             // Using query method for both  inserting ,retrieving and other operations
             String sql ="SELECT * FROM student";

             // execute query
             boolean status = statement.execute(sql);
             if(status){
                 //Select -->True
                ResultSet rs = statement.getResultSet();
                 System.out.println("If block executed");
                while(rs.next()){

                    System.out.println(rs.getInt("id")+" "+rs.getInt("age")+" " +rs.getInt("marks")+" "
                            +rs.getString("city")+" "+rs.getString("name"));
                }
             }
             else{
                 //insert ,update delete-->False
                 System.out.println("else block executed");
                 int rowAffected =statement.getUpdateCount();
                 if (rowAffected == 0) {
                     System.out.println("Operation failed!");

                 } else {
                     System.out.println("Operation successfully!");
                 }
             }
         } catch (SQLException e){
             e.printStackTrace();
         }
         catch (Exception e){
             e.printStackTrace();
         }
         finally {

             //Close the connection
             try {
              jdbcUtil.closeConnection(connection,statement);
             } catch (SQLException e) {
                 throw new RuntimeException(e);
             }
         }
        }
    }
