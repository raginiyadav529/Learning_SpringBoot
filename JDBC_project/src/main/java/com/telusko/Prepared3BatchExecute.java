package com.telusko;
import java.sql.*;
import java.util.Scanner;

public class Prepared3BatchExecute {

    // **** Batch execute work only with Non -select(insert/update/delete)

    public static void main (String[]args){

        Connection connection =null;
        PreparedStatement pstmt =null;

        try{
            connection=jdbcUtil.getConnection();
            String sql="UPDATE student SET age =? WHERE id =?";
            pstmt =  connection.prepareStatement(sql);

            System.out.println("Please Enter the following details to be stored in DB");

            Scanner sc = new Scanner(System.in);
            for (int i = 1; i <= 3; i++) {

                System.out.println("Enter id:");
                int id = sc.nextInt();                   // Using   --> this or--

                System.out.println("Enter age:");
                int age = sc.nextInt();

                pstmt.setInt(1, age);
                pstmt.setInt(2, id);
                pstmt.addBatch();
            }
            pstmt.executeBatch();

            pstmt.setInt(1,12);
            pstmt.setInt(2,103);          // *** --> that -->Directly inserting values
            pstmt.addBatch();
            pstmt.setInt(1,13);
            pstmt.setInt(2,104);
            pstmt.addBatch();
            pstmt.setInt(1,14);
            pstmt.setInt(2,105);
            pstmt.addBatch();


//            pstmt.executeBatch();
            System.out.println("Check the DB to see result");

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
