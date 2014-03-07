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
    Semaphore semaphore;
    Buffer buffer;
    
    public Consumer(Semaphore s,Buffer b){
        semaphore = s;
        buffer = b;
       }
    
    
    
    
    @Override
    public void run() {
    
    
    
    }
}
