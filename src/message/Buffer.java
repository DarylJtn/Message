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
    int front = 0;
    int rear  = 0;
    int numCon; //number of consumers
    int numReads;//number of times the messages have been read
    String bufferMessage;
    int slots;//number of slots in the buffer that messages can be stored in
     private String[] messages;
     
    int count;//count of the number of messages stored
    
    public Buffer(Semaphore s){
    semaphore = s;
    }
    
    
     public Buffer(int consumer, int s){
        this.numCon = consumer;
        numReads = consumer;
        slots = s;
        messages = new String[10];
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
            Delay.idleUpTo(10);
        System.out.println("Posting message: "+ s+"//numCon: "+ numCon);
    message = s;
    numReads = 0;
    messages[0] = s;
        rear = rear + 1;
        count = count + 1;
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
    Delay.idleUpTo(10);
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
