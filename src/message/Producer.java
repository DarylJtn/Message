/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import java.util.concurrent.Semaphore;
import java.lang.Object;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daryljohnston
 */
public class Producer extends Thread {
  Semaphore semaphore;
  Buffer buffer;
  Random randString = new Random();
  
  
  
  //take global spmaphore and buffer class
  public Producer(Semaphore s,Buffer b){
  semaphore = s;
  buffer = b;
  }
  
  
    @Override
    public void run() {
    //System.out.println(generateString());
     
      //try to aquire the semaphore   
      try {
      semaphore.acquire();   
      }
      catch ( InterruptedException e)
        {System.out.println(e);}
        
        
        //check if ther is a space in the buffer
       
    while(!buffer.isEmpty){//while buffer is full
       semaphore.release(); //release the semaphore
       System.out.println("Unable to add message to buffer");
       Delay.skip(10);//and delay for a while and check the buffer again.
           
            try {
                semaphore.acquire();
            }
            catch (InterruptedException ex) {
                System.out.println(ex);
            }
    }
    
    
    
    
    }
  
    
    public static String generateString(Random rng, String characters, int length)
{
    char[] text = new char[length];
    for (int i = 0; i < length; i++)
    {
        text[i] = characters.charAt(rng.nextInt(characters.length()));
    }
    return new String(text);
}

}
