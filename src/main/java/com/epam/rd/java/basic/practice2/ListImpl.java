package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class ListImpl implements List {

    public class Node {
        Object currentElement;
        // Ссылка на следующий узел текущего узла
        Node nextElement;
        // Ссылка на предыдущий узел текущего узла
        Node prevElement;

        public Node(Object currentElement, Node nextElement, Node prevElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }
    }

    private int size = 0; // Записать размер LinkedList
    private Node head; // указывает головной узел LinkedList
    private Node last; // указывает на хвостовой узел LinkedList

    public ListImpl() {
        head = new Node(null, null, last);
        last = new Node(null, head, null);
    }


    @Override
    public void clear() {
        if (size > 0) {
            head = null;
            last = null;
            size = 0;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        int counter = 0;

        @Override
        public boolean hasNext() {
            return counter >= 0;
        }

        @Override
        public Object next() {
            return null;
        }

    }

    @Override
    public void addFirst(Object element) {

        final Node first = head;
        final ListImpl.Node newNode = new ListImpl.Node(element, first, null);
        head = newNode;
        if (first == null) {
            last = newNode;
        } else {
            head.prevElement = newNode;
            size++;
        }


//        Node next = new Node();
//        next.setCurrentElement(element);
//        firstNode = new Node(null, null, next);
//        next.setCurrentElement(firstNode);
//        size++;
    }

    @Override
    public void addLast(Object element) {
//        Node prev = lastNode;
//        prev.setCurrentElement(element);
//        lastNode = new Node(null, prev, null);
//        prev.setNextElement(lastNode);
//        size++;
    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public Object getFirst() {
        return null;
    }

    @Override
    public Object getLast() {
        return null;
    }

    @Override
    public Object search(Object element) {
        return null;
    }

    @Override
    public boolean remove(Object element) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = head;
        while (temp != null) {
            sb.append(temp.currentElement + ",");
            temp = temp.nextElement;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        //Can test classes here
    }
}
