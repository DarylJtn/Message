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
    int pointer = 0;
    public Consumer(Buffer b, String id){
        name = id;
        this.buffer = b;
       }
    
    
    
    
    @Override
    public void run() {
    
            while(true){
       Delay.idleUpTo(19);     
    message = buffer.readMessage(message, pointer);
     System.out.println(name+ " Read Message "+ message);
    pointer++;
    Delay.idleUpTo(5);
            }
    
    }
}
