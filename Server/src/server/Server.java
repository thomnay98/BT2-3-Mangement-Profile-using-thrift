/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import thrift.UserService;

/**
 *
 * @author thom
 */
public class Server {

    public void start(){
        try {
            TServerSocket serverTransport = new TServerSocket(7979);
            
            UserServiceHandler handler = new UserServiceHandler();
 
            UserService.Processor<UserService.Iface> processor = new UserService.Processor<UserService.Iface>(handler);
 
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            
            System.out.println("Starting server on port 7979 ...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
    
}
