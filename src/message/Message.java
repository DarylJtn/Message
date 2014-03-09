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
       
        Buffer buffer = new Buffer(3);//messages will be stored here
        
        Producer producer = new Producer(buffer);
        producer.start();
        
        Consumer con1 = new Consumer(buffer);
        con1.start();
        Consumer con2 = new Consumer(buffer);
        con2.start();
        Consumer con3 = new Consumer(buffer);
        con3.start();
        
    }
}
