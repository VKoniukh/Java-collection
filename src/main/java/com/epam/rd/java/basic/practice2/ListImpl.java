package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class ListImpl implements List {

    private int size = 0; // Записать размер LinkedList
    private Node firstNode; // указывает головной узел LinkedList
    private Node lastNode; // указывает на хвостовой узел LinkedList

    public ListImpl() {
        lastNode = new Node(null, firstNode, null);
        firstNode = new Node(null, null, lastNode);
    }

    private static class Node<E> {
        private E currentElement;
        // Ссылка на следующий узел текущего узла
        private Node<E> nextElement;
        // Ссылка на предыдущий узел текущего узла
        private Node<E> prevElement;

        private Node(E currentElement, Node<E> nextElement, Node<E> prevElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public E getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(E currentElement) {
            this.currentElement = currentElement;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<E> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<E> prevElement) {
            this.prevElement = prevElement;
        }
    }


    @Override
    public void clear() {
        if (size > 0) {
            firstNode = null;
            lastNode = null;
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
        Node next = firstNode;
        next.setCurrentElement(element);
        firstNode = new Node(null, null, next);
        next.setCurrentElement(firstNode);
        size++;
    }

    @Override
    public void addLast(Object element) {
        Node prev = lastNode;
        prev.setCurrentElement(element);
        lastNode = new Node(null, prev, null);
        prev.setNextElement(lastNode);
        size++;
    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public Object getFirst() {
        Node target1 = firstNode.getNextElement();
        return target1;
    }

    @Override
    public Object getLast() {
        Node target2 = lastNode.getPrevElement();
        return target2;
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
        Node temp = firstNode;
        while(temp != null){
            sb.append(temp.currentElement+",");
            temp = temp.nextElement;
        }
        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        //Can test classes here
    }
}
