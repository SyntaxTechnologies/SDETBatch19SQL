package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class E3 {
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
        // Resultset contains the actual data from tables
        ResultSet resultset= statement.executeQuery(query);
        ResultSetMetaData rsm=resultset.getMetaData();
        List<Map<String,String>> tableData=new ArrayList<>();

        //next() checks if there are any more rows in the ResultSet if yes it returns true
            // and moves the cursor to the next row
        while(resultset.next()){
            Map<String,String> rowMap=new LinkedHashMap<>();
            for (int i = 1; i <=rsm.getColumnCount() ; i++) {
                //getting the column names from resultsetmetadata
                String key=rsm.getColumnLabel(i);
                //getting the actual data from rs
                String value=resultset.getString(i);
                rowMap.put(key,value);
            }
            tableData.add(rowMap);

        }

            System.out.println(tableData);
        // Break till 11:52
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}
