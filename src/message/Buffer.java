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
    Semaphore semaphore;
    boolean isEmpty = true;
    
    
    
    
    public Buffer(Semaphore s){
    semaphore = s;
    }
    
    
     public Buffer(){
        
    }
    
    
    public void addMessage(String s){
    
    message = s;
    
    }
    
    public String readMessage(){
    return message;
    
    }
    
    public Boolean isEmpty(){
    //todo add a system where it checks if the message has been read by all of the users
    
    return isEmpty;
    }
    
}
