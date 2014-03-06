/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import java.util.concurrent.Semaphore;

/**
 *
 * @author daryljohnston
 */
public class Message {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Semaphore s = new Semaphore(1);//creates a semaphore that the producers and 
        Buffer buffer = new Buffer();//messages will be stored here
        
        Producer producer = new Producer(s,buffer);
        
        
        
        
    }
}
