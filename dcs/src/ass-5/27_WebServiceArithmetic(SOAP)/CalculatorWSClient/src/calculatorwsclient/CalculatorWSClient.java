/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorwsclient;

/**
 *
 * @author harshada
 */
public class CalculatorWSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            int i=10;
            int j=20;
                int res=add(i,j);
                System.out.println("A:"+res);
                
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    private static int add(int i, int j) {
        org.me.calculator.Calculator_Service service = new org.me.calculator.Calculator_Service();
        org.me.calculator.Calculator port = service.getCalculatorPort();
        return port.add(i, j);
    }

   
    
    
}
