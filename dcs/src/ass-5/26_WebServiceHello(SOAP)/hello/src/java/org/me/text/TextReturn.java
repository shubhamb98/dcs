/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.text;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author harshada
 */
@WebService(serviceName = "TextReturn")
@Stateless()
public class TextReturn {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ReturnText")
    public String ReturnText(@WebParam(name = "parameter") String parameter) {
        //TODO write your implementation code here:
        return "Hello " + parameter ;
    }
}
