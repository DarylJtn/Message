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


public class Consumer extends Thread {
    
    Buffer buffer;
    
    public Consumer(Buffer b){
    
        this.buffer = b;
       }
    
    
    
    
    @Override
    public void run() {
    
    
    
    }
}
