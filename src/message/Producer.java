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
 
  Buffer buffer;//an instance of buffer that will be created in the message.java class
  Random randString = new Random();//instance of random so that a random string can be made
  
    public static String generateString(Random rng)
{
    String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";//characters that can be used in rand string
    char[] text = new char[20];//new array of char's that has 20 valuse
    for (int i = 0; i < 20; i++)//for each item in the text array
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
            
    //get the message from the buffer
     buffer.addMessage(generateString(randString));
     Delay.idleUpTo(3);//wait for up to 3 sec


        }
        }

}
