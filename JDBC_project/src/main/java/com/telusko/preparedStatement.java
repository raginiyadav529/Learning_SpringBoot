package com.telusko;

import java.sql.*;
import java.util.Scanner;

public class preparedStatement {

    public static void main (String[]args){

        Connection connection =null;
        PreparedStatement pstmt =null;

        try{
            connection=jdbcUtil.getConnection();

            String sql ="INSERT INTO student(id,age,marks,city,name)VALUES(?,?,?,?,?)";
            pstmt =  connection.prepareStatement(sql);

            System.out.println("Please Enter the following details to be stored in DB");
            Scanner sc =new Scanner(System.in);
            System.out.println("Enter your id");
            Integer id = sc.nextInt();
            System.out.println("Enter your age");
            Integer age =sc.nextInt();
            System.out.println("Enter your marks");
            Integer marks =sc.nextInt();
            System.out.println("Enter you City");
            String city =sc.next();
            System.out.println("Enter your name");
            String name =sc.next();

            pstmt.setInt(1,id);
            pstmt.setInt(2,age);
            pstmt.setInt(3,marks);
            pstmt.setString(4,city);
            pstmt.setString(5,name);

             int rowAffected = pstmt.executeUpdate();
             if(rowAffected ==0){
                 System.out.println("Operation Failed !");
             }
             else{
                 System.out.println("Operation Successfuly !");
             }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {

            try {
                jdbcUtil.closeConnection(connection,pstmt);
            }
            catch (SQLException e) {

                throw new RuntimeException(e);
            }
        }
    }
}
