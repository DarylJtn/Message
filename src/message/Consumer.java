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
        name = id;
        this.buffer = b;
       }
    
    
    
    
    @Override
    public void run() {
    
            while(true){
            Delay.idleUpTo(10);
    message = buffer.readMessage(message);
     System.out.println(name+ " Read Message "+ message);

            }
    
    }
}
