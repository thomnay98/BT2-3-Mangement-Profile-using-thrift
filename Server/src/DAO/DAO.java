/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import net.spy.memcached.MemcachedClient;
import thrift.User;

/**
 *
 * @author thom
 */
public class DAO {
    private Connection connection;
    protected Hashtable<String, User> hash_table = new Hashtable<>();
    protected MemcachedClient mcc = null;
    
    public DAO(Connection connection) {
        this.connection = connection;
    }
    
    private void printSqlException(SQLException exception) {
        System.err.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.err.println("SQL exception!");
        System.err.println("SQL state: " + exception.getSQLState() + "; Error code: " + exception.getErrorCode());
        System.err.println("Message: " + exception.getMessage());
        System.err.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    public boolean register(User user){
        boolean set = false;
        try{
            try (PreparedStatement statement = connection.prepareStatement(Constants.REGISTER)) {
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getPassword());
                statement.setString(4, user.getAddress());
                statement.setString(5, user.getPhone());
                statement.execute();
                
                set = true;
            }
            
            System.out.println("Đăng ký thành công!");
        }catch(SQLException e){
            printSqlException(e);
        }
        return set;
    }
    
    public User login(String email, String passW) throws IOException{
        User user = new User();
        
            mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1",11211));
            User userM = new User();
            userM = (User) mcc.get(email);
            
            if(userM != null){
                if(userM.getPassword().equals(passW)){
                    user = (User) mcc.get(email);
                    System.out.println("Get from Memcached");
                }else{
                    System.out.println("wrong password");
                }
                
            }else{
                try{
                    try (PreparedStatement statement = connection.prepareStatement(Constants.LOGIN)) {
                        statement.setString(1, email);
                        statement.setString(2, passW);

                        ResultSet rs = statement.executeQuery();
                        if(rs.next()){
                            user = new User();
                            user.setId(rs.getInt("uID"));
                            user.setName(rs.getString("Name"));
                            user.setEmail(rs.getString("Email"));
                            user.setPassword(rs.getString("Password"));
                            user.setAddress(rs.getString("Address"));
                            user.setPhone(rs.getString("Phone"));
                        }

                        if(user.getId() != 0){
                            mcc.set(user.getEmail(), (60*60*24), user);
                        }

                        statement.execute();
                    }

                }catch (SQLException e){
                    printSqlException(e);
                }
            }
        
        
        //caching with Hashtable
        
//        User userH = new User();
//        userH = hash_table.get(email);
//
//        if(userH != null){
//            if(userH.getPassword().equals(passW)){
//                user = userH;
//            }else{
//                System.out.println("wrong password");
//            }
//
//        }else{
//            try{
//                try (PreparedStatement statement = connection.prepareStatement(Constants.LOGIN)) {
//                    statement.setString(1, email);
//                    statement.setString(2, passW);
//
//                    ResultSet rs = statement.executeQuery();
//                    if(rs.next()){
//                        user = new User();
//                        user.setId(rs.getInt("uID"));
//                        user.setName(rs.getString("Name"));
//                        user.setEmail(rs.getString("Email"));
//                        user.setPassword(rs.getString("Password"));
//                        user.setAddress(rs.getString("Address"));
//                        user.setPhone(rs.getString("Phone"));
//                    }
//
//                    if(user.getId() != 0){
//                        hash_table.put(user.getEmail(), user);
//                    }
//
//                    statement.execute();
//                }
//
//            }catch (SQLException e){
//                printSqlException(e);
//            }
//        }
        
        return user;
    }
    
    public boolean deleteUser(String email){
        boolean set = false;
        
        try{
            try(PreparedStatement statement = connection.prepareStatement(Constants.EXIST)){
                statement.setString(1, email);
                ResultSet rs = statement.executeQuery();
                int ex = 0;
                if(rs.next()){
                    ex++ ; 
                }
                
                if(ex > 0){
                    try (PreparedStatement stm = connection.prepareStatement(Constants.DELETE)) {
                        stm.setString(1, email);
                        stm.execute();
                    }

                    // delete user in Hashtable
        //            if(hash_table.get(email) != null){
        //                hash_table.remove(email);
        //            }

                    // delete user in memcached
                    if(mcc.get(email)!= null){
                        mcc.delete(email);
                    }
//                    
//                    System.out.println(mcc.get(email));

                    set = true;
                }else {
                    set = false;
                }
            }
        }catch (SQLException e){
            printSqlException(e);
        }
        
        return set;
    }
        
//    private static String securedPassword(String pw){
//        String hashPw = null;
//        
//        try{  
//             
//            MessageDigest m = MessageDigest.getInstance("MD5");  
//               
//            m.update(pw.getBytes());  
//               
//            byte[] bytes = m.digest();  
//               
//            StringBuilder s = new StringBuilder();  
//            for(int i=0; i< bytes.length ;i++)  
//            {  
//                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
//            }  
//              
//            hashPw = s.toString();  
//        }catch (NoSuchAlgorithmException e){  
//            e.printStackTrace();  
//        }  
//        
//        return hashPw;  
//    } 
}
