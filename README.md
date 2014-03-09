COM577 Concurrent and Distributed Systems
Assignment 1
Date Set: 18 February 2014
Date Due: 14 March 2014


This assignment carries 50% of the coursework marks for this module. It should be
uploaded to Blackboard by midnight of the due date.

Atomic Broadcast: Assume that one producer process and n consumer processes
share a single-slot buffer. The producer deposits messages into the buffer and consumers fetch them. Every message deposited by the producer has to be fetched by all
n consumers before the producer can deposit another message into the buffer.
Question 1a (i) Develop a solution for this problem using semaphores for synchronization.
(20 marks)

1a (ii) Implement the solution in Java and demonstrate that the program has the required property. You should introduce random delays in various processes in such a
way that a flaw in the program, if there, would be exposed.
(20 marks)

Next, assume the buffer has b slots. The producer can deposit messages only into
empty slots and every message has to be retrieved by all n consumers before the
slot can be reused. Furthermore, each consumer is to retrieve messages in the order
they were deposited. However, different consumers can receive messages at different
times. For example, one consumer could receive up to b more messages than another
if the second consumer is slow. The producer attempts to leave a message in a slot as
soon as it is possible to do so.
1b (i) Extend the solution in 1a(i) to solve the more general problem.
(30 marks)

1b(ii) Implement the solution in Java and demonstrate that the program has the required property.
(30 marks)

The solutions developed in Questions 1a(i) and 1b(i) should be typeset in pdf with 1.5
line spacing and generous margins. Netbeans projects for Questions 1a(ii) and 1b(ii)
should be submitted as zip files.
