package org.basics;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConceptsClass {

    /*
       JDBcC
          java db connectivity
          - api
          - connect with db =>
          - part javaSE
          - using driver to connect with db
     */

    // connection with db
    // register the driver class   => forName()
    // create connection    => getConnection(url,user,password)   DriverManager
    // create statement     => create statement
    //  execute queries      => execute query
    // close connection

    private static Connection connection = null;

    public static Connection connection () {
        String url = "jdbc:mysql://localhost/jdbctest";
        String username = "root";
        String password = "";
        try {
            // load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
