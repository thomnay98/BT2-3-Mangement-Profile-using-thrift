/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author thom
 */
public class Constants {
    static final String LOGIN = "SELECT * FROM Users WHERE Email = ? and Password = ?";
    
    static final String REGISTER= "INSERT INTO Users (Name, Email, Password, Address, Phone) VALUES (?,?,?,?,?)";

    static final String EXIST = "SELECT * FROM Users WHERE Email = ?";
    static final String DELETE = "DELETE FROM Users WHERE Email = ?";

    static final String URL = "jdbc:mysql://localhost:3306/UserProfileDB";
    static final String USERNAME = "root";
    static final String PASSWORD = "102798Ut!";
}
