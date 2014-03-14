/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import java.util.concurrent.Semaphore;
import static message.Producer.generateString;

/**
 *
 * @author daryljohnston
 */


public class Consumer extends Thread {
    
    Buffer buffer;
    String message;
    String name;
    public Consumer(Buffer b, String id){
        name = id;//takes the thread name used to track and identify what thread is reading
        this.buffer = b;//instance of buffer created in the message.java class
       }
    
    
    
    
    @Override
    public void run() {
    
            while(true){
            Delay.idleUpTo(10);//wait for up to 10 seconds
    message = buffer.readMessage(message);//get the variable from the buffer and 
                                            //pass in the prev read message
     System.out.println(name+ " Read Message "+ message);//print the message to the console
            }
    
    }
}
