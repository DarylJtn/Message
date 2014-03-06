/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

/**
 *
 * @author daryljohnston
 */
public class Delay {

    public static void idleUpTo(double seconds) {
        
        double thousandths = (int) (1000.0 * seconds);
        double randomSleepLength = thousandths * Math.random();
        long   randomSleep   = (long) randomSleepLength;
        try {
            Thread.currentThread().sleep(randomSleep);
        }
        catch (InterruptedException e) {}
    }    
    public static void skip(double seconds) {
        
        int thousandths = (int) (1000.0 * seconds);
         try {
            Thread.currentThread().sleep(thousandths);
        }
        catch (InterruptedException e) {}
    }
}
