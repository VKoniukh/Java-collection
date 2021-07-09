package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class QueueImpl implements Queue {

    Node head; // Голова очереди
    Node tail; // Хвост очереди
    int size;

    class Node {
        Node prev;
        Node next;
        Object data;

        public Node(Object data) {
            super();
            this.data = data;
        }
    }


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
//        Node newNode = new Node();
//        // Пустая очередь
//        if (head == null) {
//            head = newNode;
//            tail = newNode;
//            size++;
//        } else {
//            Node node = tail;
//            newNode.next = node;
//            node.prev = newNode;
//            tail = newNode;
//            size++;
//
        return null;
    }

    @Override
    public String toString() {
        return null;
    }


    public static void main(String[] args) {

    }

}
