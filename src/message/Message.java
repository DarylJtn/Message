/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * question 2
 */
package message;

import java.util.concurrent.Semaphore;

/**
 *
 * @author daryljohnston
 */
public class Message {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        int slots = 3;//define the number of slots the buffer has here
        int numConsumers = 3;//define the number of consumers in the program here
        
        Buffer buffer = new Buffer(numConsumers, slots);//messages will be stored here
        
        Producer producer = new Producer(buffer);
        producer.start();
       
        Consumer con1 = new Consumer(buffer,"Consumer One", slots);
        con1.start();
        Consumer con2 = new Consumer(buffer,"Consumer Two", slots);
        con2.start();
        Consumer con3 = new Consumer(buffer, "Consumer Three", slots);
        con3.start();
        //Consumer con4 = new Consumer(buffer,"Consumer Four", slots);
        //con4.start();
        //Consumer con5 = new Consumer(buffer,"Consumer Five", slots);
        //con5.start();
        //Consumer con6 = new Consumer(buffer, "Consumer Six", slots);
        //con6.start();
    }
}
