package org.example;

import java.sql.*;

public class E1 {
    public static void main(String[] args) {
        // A db url string it contains all the
        // required info to connect to any database
            String dbURL="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
            String userName="syntax_hrm";
            String password="syntaxhrm123";
        try {
            // creates a connection to the database
        Connection connection=DriverManager.getConnection(dbURL,userName,password);
        /*
        take the queries from java code execute them on the database and bring the results back
        into your java program.
         */
        Statement statement=connection.createStatement();
        String query="Select * from person";
        ResultSet resultset= statement.executeQuery(query);
        //next() checks if there are any more rows in the ResultSet if yes it returns true
            // and moves the cursor to the next row
        while(resultset.next()){
            String firstname=resultset.getString("FirstName");
            int age=resultset.getInt("age");
            String city=resultset.getString("city");
            System.out.println(firstname+" "+age+" "+city);
        }

        // Break till 11:52
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}
