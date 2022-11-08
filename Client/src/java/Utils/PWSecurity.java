/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author thom
 */
public class PWSecurity {
    
    public PWSecurity (){}
    
    public String securedPassword(String pw){
        String hashPw = null;
        
        try{  
             
            MessageDigest m = MessageDigest.getInstance("MD5");  
               
            m.update(pw.getBytes());  
               
            byte[] bytes = m.digest();  
               
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }  
              
            hashPw = s.toString();  
        }catch (NoSuchAlgorithmException e){  
            e.printStackTrace();  
        }        
        return hashPw;
    }
    
}
