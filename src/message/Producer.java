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
  
  
  
  
  public Producer(Semaphore s,Buffer b){
  semaphore = s;
  buffer = b;
  }
  
  
    @Override
    public void run() {
    //System.out.println(generateString());
       
      try {
      semaphore.acquire();   
      }
      catch ( InterruptedException e)
        {System.out.println(e);}
        
        
        
    while(!buffer.isEmpty){
       semaphore.release(); 
       System.out.println("Unable to add message to buffer");
       Delay.skip(10);
           
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
