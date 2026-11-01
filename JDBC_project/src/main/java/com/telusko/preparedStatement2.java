package com.telusko;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Scanner;

public class preparedStatement2 {      // ********* Performing CRUD operations using PreparedStatement

    public static void main (String[]args){

        Connection connection =null;
        PreparedStatement pstmt =null;

        try{
            connection=jdbcUtil.getConnection();
            String sql3="SELECT id,age,marks,city,name FROM student WHERE id =?";    // Retrieve

//            String sql="UPDATE student SET age=? WHERE id =?";  //Update
//            String sql2 ="DELETE FROM student WHERE id =?";       // Delete
            pstmt =  connection.prepareStatement(sql3);

            System.out.println("Please Delete the following details to be stored in DB");
            Scanner sc =new Scanner(System.in);

//            System.out.println("Enter your age");
//            Integer age =sc.nextInt();

            System.out.println("Enter your id");
            Integer id = sc.nextInt();


//             pstmt.setInt(1,age);
            pstmt.setInt(1,id);

//            int rowAffected = pstmt.executeUpdate();
//            if(rowAffected ==0){
//                System.out.println("Operation Failed !");
//            }
//            else{
//                System.out.println("Operation Successfuly !");
//            }

            ResultSet rs  = pstmt.executeQuery();

            if(rs.next()){

            Integer sid =  rs.getInt(1);
            Integer sage =  rs.getInt(2);
            Integer smarks =  rs.getInt(3);
            String  scity =  rs.getString(4);
            String sname =  rs.getString(5);

                System.out.println(sid +" "+sage+" "+smarks+" "+scity+" "+sname);
            }
            else{
                System.out.println("There is no record with id"+id);
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
