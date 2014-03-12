/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

/**
 *
 * @author daryljohnston
 */
public class Cond {
    
    /** Creates a new instance of Cond */
    public Cond() {
    }
    
    public synchronized void condWait() {
        try {
            wait();
        }
        catch (InterruptedException e) {}
    } 
    public synchronized void signal() {
        notify();
    }
    
    public synchronized void signalAll() {
        notifyAll();
    }
}
