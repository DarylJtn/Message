/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import java.util.concurrent.Semaphore;
import java.lang.Object;
import java.util.Random;

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
    while(!buffer.isEmpty){
    
    
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
