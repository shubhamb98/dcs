/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempclient;

/**
 *
 * @author harshada
 */
public class TempClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            float F,C;
            F=44;
            C=conversion(F);
            System.out.println("Celcius:"+C);
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    private static float conversion(float farenheight) {
        org.me.temp.Temperature_Service service = new org.me.temp.Temperature_Service();
        org.me.temp.Temperature port = service.getTemperaturePort();
        return port.conversion(farenheight);
    }
    
    
}
