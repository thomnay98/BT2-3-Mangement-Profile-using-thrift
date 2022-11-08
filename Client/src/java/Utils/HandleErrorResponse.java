/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import thrift.HandleResponse;
import thrift.User;

/**
 *
 * @author thom
 */
public class HandleErrorResponse {
    
    public HandleErrorResponse () {}
    
    public HandleResponse handleResponse(int errCode, String errMessage, String ssID, User data){
        HandleResponse resData = new HandleResponse();
        
        resData.setErrCode(errCode);
        resData.setErrMessage(errMessage);
        resData.setSsID(ssID);
        resData.setUser(data);
        
        return resData;
    }
}
