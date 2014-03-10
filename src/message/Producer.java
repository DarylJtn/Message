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
 
  Buffer buffer;
  Random randString = new Random();
  
  public void postMessage(){

  
  
  }
    public static String generateString(Random rng)
{
    String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] text = new char[20];
    for (int i = 0; i < 20; i++)
    {
        text[i] = characters.charAt(rng.nextInt(characters.length()));
    }
    return new String(text);
}
  
  
  //take global spmaphore and buffer class
  public Producer(Buffer b){

  this.buffer = b;
  }
  
  
    @Override
    public void run() {
        
        while(true){
            
    
     buffer.addMessage(generateString(randString));
     Delay.idleUpTo(3);

            
            
            
   
        
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
