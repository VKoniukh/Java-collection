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

    public class Node<E> {
        private E currentElement;
        // Ссылка на следующий узел текущего узла
        private Node<E> nextElement;
        // Ссылка на предыдущий узел текущего узла
        private Node<E> prevElement;

        private Node(Node<E> prevElement, E currentElement, Node<E> nextElement) {
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
    }

    @Override
    public int size() {
        return size;
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
    public void addFirst(Object element) {
    }

    @Override
    public void addLast(Object element) {
        Node prev = lastNode;
        prev.setCurrentElement(element);
        lastNode = new Node(null,null,prev);
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
        return target1.getCurrentElement();
    }

    @Override
    public Object getLast() {
        Node target2 = lastNode.getPrevElement();
        return target2.getCurrentElement();
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
        return null;
    }

    public static void main(String[] args) {
        //Can test classes here
    }
}
