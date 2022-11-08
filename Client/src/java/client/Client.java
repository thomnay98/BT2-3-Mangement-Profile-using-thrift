package client;


import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import thrift.InvalidOperation;
import thrift.User;
import thrift.UserService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thom
 */
public class Client {
    private UserService.Client client;

    public Client(){
        TTransport transport;
        try {
            transport = new TSocket("localhost", 7979);
            transport.open();

            TProtocol protocol = new TBinaryProtocol(transport);
            client = new UserService.Client(protocol);

        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
    
    public boolean registerUser(User user){
        try {
                return client.registerUser(user);
        } catch (InvalidOperation e) {
                System.out.println(e.getMessage());
        } catch (TException e) {
                handleThriftException(e);
        }
        return false;
    }
    
    public User loginUser(String email, String password){
        try {
                return client.loginUser(email, password);
        } catch (InvalidOperation e) {
                System.out.println(e.getMessage());
        } catch (TException e) {
                handleThriftException(e);
        }
        return null;
    }
    
    public boolean deleteUser(String email){
        try {
                return client.deleteUser(email);
        } catch (InvalidOperation e) {
                System.out.println(e.getMessage());
        } catch (TException e) {
                handleThriftException(e);
        }
        return false;
    }
    
    private void handleThriftException(TException ex) {
		System.out.println("An error occured while communicating with server!");
	}
}
