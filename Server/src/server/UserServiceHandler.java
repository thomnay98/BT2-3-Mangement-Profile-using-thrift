/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import DAO.ConnectDB;
import DAO.DAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.thrift.TException;
import thrift.InvalidOperation;
import thrift.User;
import thrift.UserService;

/**
 *
 * @author thom
 */
public class UserServiceHandler implements UserService.Iface {
    private DAO dao;
    
    public UserServiceHandler() {
        try {
            dao = new DAO(ConnectDB.getConnection());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserServiceHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean registerUser(User user) throws InvalidOperation, TException {
        return dao.register(user);
    }

    @Override
    public User loginUser(String email, String password) throws InvalidOperation, TException {
        if(dao.login(email, password) != null){
            return dao.login(email, password);
        }else return null;
    }

    @Override
    public boolean deleteUser(String Email) throws InvalidOperation, TException {
        return dao.deleteUser(Email);
    }
}
