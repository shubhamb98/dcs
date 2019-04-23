/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textclient;

/**
 *
 * @author harshada
 */
public class TextClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(hello("rscoe"));
    }

    private static String hello(java.lang.String name) {
        org.mew.txt.Textt_Service service = new org.mew.txt.Textt_Service();
        org.mew.txt.Textt port = service.getTexttPort();
        return port.hello(name);
    }
    
}
