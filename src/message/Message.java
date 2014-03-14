/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * question 1
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
        int numConsumer = 4;//number of consumers
        Buffer buffer = new Buffer(numConsumer);//messages will be stored here
        
        Producer producer = new Producer(buffer);//create an instance of producer
        producer.start();//start the producer thread
        
        Consumer con1 = new Consumer(buffer,"Consumer One");//create a consumer and pass in the buffer
        con1.start();
        Consumer con2 = new Consumer(buffer,"Consumer Two");
        con2.start();
        Consumer con3 = new Consumer(buffer, "Consumer Three");
        con3.start();
        Consumer con4 = new Consumer(buffer,"Consumer Four");
        con4.start();
        //Consumer con5 = new Consumer(buffer,"Consumer Five");
        //con5.start();
        //Consumer con6 = new Consumer(buffer, "Consumer Six");
        //con6.start();
    }
}
