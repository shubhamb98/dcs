/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.temp;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author harshada
 */
@WebService(serviceName = "Temperature")
@Stateless()
public class Temperature {

    /**
     * This is a sample web service operation
     */
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Conversion")
    public float Conversion(@WebParam(name = "Farenheight") float Farenheight) {
        //TODO write your implementation code here:
        float Celcius;
        Celcius =((Farenheight-32)*5)/9;
        
        return Celcius;
    }
}
