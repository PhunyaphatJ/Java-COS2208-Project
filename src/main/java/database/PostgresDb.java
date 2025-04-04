/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author black
 */
public class PostgresDb{

    static Connection connectionInstance = null;
  

    public static Connection getConnection(Config config) {
        if (connectionInstance == null) {
            String url = String.format("jdbc:postgresql://localhost:%s/%s",config.getDbPort(),config.getDbName()); 
            String user = config.getDbUser(); 
            String password = config.getDbPassword();
            try {

                connectionInstance = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to PostgreSQL successfully!");
                
            } catch (SQLException e) {
                System.out.println("Connection failed!");
                e.printStackTrace();
            }
        }

        return connectionInstance;
    }
}


