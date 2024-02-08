# Queue-Implementation

This repository contains a Java implementation of a queue abstract data type (ADT) and two concrete implementations: a linked queue and a circular queue.

## Classes

The project consists of four classes:

- **Queue_ADT**: This class contains the main method that creates a linked queue and a circular queue object and tests some of the methods on them.
- **Node**: This class represents a node in a linked queue, which has a data field and a next pointer. It also has two constructors and a toString method.
- **Queue_Linked**: This class represents a linked queue, which has a front node, a rear node, and a size. It also implements the queue ADT methods: enqueue, dequeue, isFull, isEmpty, toString, and getFront.
- **circularQueue**: This class represents a circular queue, which uses an array to store the elements. It also has a front index, a rear index, a capacity, and a size. It also implements the queue ADT methods: enqueue, dequeue, isFull, isEmpty, toString, and getFront.

## Methods

The queue ADT methods are as follows:

- **enqueue**: This method adds a new element to the rear of the queue. It throws an exception if the queue is full.
- **dequeue**: This method removes and returns the element at the front of the queue. It throws an exception if the queue is empty.
- **isFull**: This method checks if the queue is full. It returns true if the queue is full or false otherwise.
- **isEmpty**: This method checks if the queue is empty. It returns true if the queue is empty or false otherwise.
- **toString**: This method returns a string representation of the queue. It shows the elements from front to rear, separated by commas.
- **getFront**: This method returns the element at the front of the queue without removing it. It throws an exception if the queue is empty.



You can modify the main method to test different methods on different queues.
