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
public class PostgresDb implements IDatabase {

    static Connection connectionInstance = null;
    Config config;
    
    public PostgresDb(Config config){
        this.config = config;
    }

    public Connection Connection() {
        String url = String.format("jdbc:postgresql://localhost:%s/%s",config.getDbPort(),config.getDbName()); 
        String user = config.getDbUser(); 
        String password = config.getDbPassword();
        System.out.println("test");
        if (connectionInstance == null) {
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
