package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Review1 {
    public static void main(String[] args) {
        String dbURL="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";

        try {
            Connection connection=DriverManager.getConnection(dbURL,userName,password);
            Statement statement=connection.createStatement();
            String query="Select * from person;"; // 2
            ResultSet rs= statement.executeQuery(query);
            //next() it checks if there are any rows in the RS
            ResultSetMetaData rsm= rs.getMetaData();
            List<Map<String,String>> tableList=new ArrayList<>();

          while (rs.next()){
              Map<String,String> row=new HashMap<>();
              for (int i = 1; i <= rsm.getColumnCount() ; i++) {
                  String key=rsm.getColumnLabel(i);
                  String value=rs.getString(i);
                  row.put(key,value);
              }
              tableList.add(row);

          }
            System.out.println(tableList);

        } catch (SQLException e) {
           e.printStackTrace();
        }

    }
}
