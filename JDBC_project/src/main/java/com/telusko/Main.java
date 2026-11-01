package com.telusko;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        // Create connection

       String url = "jdbc:mysql://localhost:3306/JDBC1";
       String user = "root";
       String password = "Ragini@123";

        Connection connection = DriverManager.getConnection(url,user,password);

        //Establishing Statement

        Statement statement = connection.createStatement();

        //Execute Query    ---->.>>>... CRUD operation  -- (executeUpdate -->Non -select method)

        //   String sql="INSERT INTO student(id,age,marks,city,name) VALUES(102,20,96,'Delhi','Fahad')";
     //   String sql="INSERT INTO student(id,age,marks,city,name) VALUES(103,21,80,'Udisha','Priyanshu')";

//        String sql1= "INSERT INTO student(id,age,marks,city,name) VALUES(104,26,79,'Hydrabad','Rahul')";
     //   String sql2 ="INSERT INTO student(id,age,marks,city,name) VALUES(105,18,82,'Noida','Sejal')";

        //Deleting data
        String sql ="DELETE FROM student WHERE id =104";

          //String sql="UPDATE student SET marks =97 WHERE id =102 ";

          //Retrieving data from database (executeQuery())

      //   String sql ="SELECT * FROM student";
        //ResultSet rs = statement.executeQuery(sql);

       /* while(rs.next()){
            System.out.println(rs.getInt("id")+ " "+ rs.getInt("age")+ " "+rs.getInt("marks")+" "+rs.getString("city")+" "+ rs.getString("name"));
        }*/

        int rowAffected= statement.executeUpdate(sql);

        // Process the result

       if(rowAffected==0){
             System.out.println("Updation failed");
       }
       else{
             System.out.println("Updation successfully");
       }

       /*  //Close the connection

       rs.close();  */
        connection.close();
       statement.close();




    }
}