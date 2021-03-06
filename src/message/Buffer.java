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
    Semaphore mutex = new Semaphore(1);
    public String message = null;
    Semaphore semaphore;
    boolean isEmpty = true;
    int numCon; //number of consumers
    int numReads;//number of times the messages have been read
    String bufferMessage;

    
    public Buffer(Semaphore s){
    semaphore = s;
    }
    
    
     public Buffer(int consumer){
        this.numCon = consumer;
        numReads = consumer;
    }
    
    
    public void addMessage(String s){
    
        
        //try to aquire the semaphore
        try { mutex.acquire(); }
        catch (InterruptedException e) {}
        
            while (numCon != numReads) {//if the number of consumers does not = the number of times the message has been read
                 mutex.release(); 
                 Delay.idleUpTo(10);
                 try { mutex.acquire(); }
            catch (InterruptedException e) {}
            }
        System.out.println("Posting message: "+ s+"//numCon: "+ numCon);
    message = s;
    numReads = 0;
    mutex.release();
    }
    
    public String readMessage(String lastRead){
    
        try { mutex.acquire(); }
        catch (InterruptedException e) {}
                
    
    while (message.equals(lastRead)) {//if the number of consumers does not = the number of times the message has been read
                 mutex.release(); 
                 Delay.idleUpTo(10);
                 try { mutex.acquire(); }
            catch (InterruptedException e) {}
            }
    bufferMessage = message;
    numReads++;
    mutex.release(); 

        return bufferMessage;
        
       
    }
    
    public Boolean isEmpty(){
    //todo add a system where it checks if the message has been read by all of the users
    
    return isEmpty;
    }
    
}
