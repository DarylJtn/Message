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
    Semaphore mutex = new Semaphore(1);//create an instance to the semaphore to sync the process
    public String message = null;//a variable for the message that the producer puts through
    int numCon; //number of consumers
    int numReads;//number of times the messages have been read
    String bufferMessage;//a temp string 

    
    
     public Buffer(int consumer){
        numCon = consumer;
        numReads = consumer;//The number of reads is set to the number of consumers
                            //so that the program starts adding messages sucessfully
    }
    
    
    public void addMessage(String s){
    
        
        //try to aquire the semaphore
        try { mutex.acquire(); }
        catch (InterruptedException e) {}
        
            while (numCon != numReads) {//if the number of consumers does not = the number of times the message has been read
                 mutex.release(); //release semaphore delay and aquire it until a new message is needed
                 Delay.idleUpTo(10);
                 try { mutex.acquire(); }
            catch (InterruptedException e) {}
            }
        System.out.println("Posting message: "+ s);//notify cosole message is printed
    message = s;//assign the string passed in to the buffers message variable
    numReads = 0;//reset the numReads varable to stop new messages being posted
    mutex.release();//release semaphore, allow other threads to function
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
    bufferMessage = message;//assign the buffers message to a new string so that 
                            //the semaphore can be released before returning the message
    numReads++;//increase num reads so that addmessage can post a message in cases
                //where all the consumers have read the message
    mutex.release(); 

        return bufferMessage;
        
       
    }
    

    
}
