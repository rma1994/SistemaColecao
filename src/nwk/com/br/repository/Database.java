/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nwk.com.br.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Richard Matheus
 */
public class Database {
    private final String DATABASE = "4Bimestre";
    private final String HOST = "jdbc:mysql://localhost:3306/" + DATABASE;
    private final String USER = "root";
    private final String PASSWORD = "";
    private Connection connection;
    
    private static Database instance;
    
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
    
    public Connection getConnection() throws SQLException{
        if(connection == null){
            connection = DriverManager.getConnection(HOST,USER,PASSWORD);
        }
        return connection;
    }
}
