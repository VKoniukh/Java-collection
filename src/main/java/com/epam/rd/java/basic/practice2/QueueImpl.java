package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class QueueImpl implements Queue {

        private Object[] arr;      // array to store queue elements
        private int front;      // front points to the front element in the queue
        private int rear;       // rear points to the last element in the queue
        private int capacity;   // maximum capacity of the queue
        private int count;      // current size of the queue

        // Constructor to initialize a queue
//        public void Queue (Object size) {
//            arr = new Object[size];
//            capacity = size;
//            front = 0;
//            rear = -1;
//            count = 0;
//        }

    public QueueImpl() {
        
    }

    @Override
    public void clear() {
        
    }

    @Override
    public int size() {
        return 0;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

    }

    @Override
    public void enqueue(Object element) {
        
    }

    @Override
    public Object dequeue() {
        return null;
    }

    @Override
    public Object top() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }

    public static void main(String[] args) {

    }

}
