/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.Constants.PASSWORD;
import static DAO.Constants.URL;
import static DAO.Constants.USERNAME;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author thom
 */
public class ConnectDB {
    private static Connection con;
    
    public static Connection getConnection() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}
