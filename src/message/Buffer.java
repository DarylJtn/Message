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
    public String message = "empty";
    Semaphore semaphore;
    int numCon; //number of consumers
    //int numReads;//number of times the messages have been read
    String bufferMessage;
    int slots;//number of slots in the buffer that messages can be stored in
     private String[] messages;
    int numMessages = 0;
    int count;//count of the number of messages stored
    int[] numberReads;
    private int[] numReads;
    public Buffer(Semaphore s){
    semaphore = s;
    }
    
    
     public Buffer(int consumer, int s){
        numCon = consumer;
      //  numReads = consumer;
        slots = s;
        messages = new String[20];
        numReads = new int[20];//keeps a count of the number of times each message has ben read
    }
    
    
    public void addMessage(String s){
    
        
        //try to aquire the semaphore
        try { mutex.acquire(); }
        catch (InterruptedException e) {}
        
            while (numMessages >= slots) {//if the number of consumers does not = the number of times the message has been read
                 mutex.release(); 
                 Delay.idleUpTo(5);
                 try { mutex.acquire(); }
            catch (InterruptedException e) {}
            }
            Delay.idleUpTo(5);
           
            if(count==20){//if the program is using the end of the array reset the account and reuse the start of the array
            count = 0;
             }
            System.out.println("Posting message: "+ s+"//numCon: "+ numCon+"// Array Placement "+ count);
    message = s;
   // numReads = 0;

    messages[count] = s;
    count = count + 1;
    numMessages++;
    Delay.idleUpTo(5);
    mutex.release();
    }
    
    public String readMessage(String lastRead, int pointer){
    
        try { mutex.acquire(); }
        catch (InterruptedException e) {}
    
        
           if (numCon==numReads[pointer]){
   //notify the program that the message has been read by all of the consumers 
       numReads[pointer] = 0;
       numMessages--;
   }
        
    while (messages[pointer].equals(lastRead)||messages[pointer].equals("empty")) {//if the number of consumers does not = the number of times the message has been read
                 
        mutex.release(); 
        Delay.idleUpTo(10);
            
            try { mutex.acquire(); }
            catch (InterruptedException e) {}
            }
    
    Delay.idleUpTo(5);
   
   
   
    bufferMessage = messages[pointer];
   numReads[pointer]++;
   //System.out.println("numReads: "+ numReads[pointer]+"// pointer: "+pointer);
   if (numCon==numReads[pointer]){
   //notify the program that the message has been read by all of the consumers 
       numReads[pointer] = 0;
       numMessages--;
      System.out.println("Num Message --");

   }
    mutex.release(); 
      
        return bufferMessage;
    }
    

    
}
