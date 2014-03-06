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
public class Buffer {
  
    String message;
    Semaphore s = new Semaphore(1);
    
    
    
    public void addMessage(String s){
    
    message = s;
    
    }
    
}
