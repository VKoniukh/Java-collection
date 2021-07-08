package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {

    public static class Node {
        Object currentElement;
        // Ссылка на следующий узел текущего узла
        Node nextElement;
        // Ссылка на предыдущий узел текущего узла
        Node prevElement;

        public Node(Node prevElement, Object currentElement, Node nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }
    }


    private int size = 0; // Записать размер LinkedList
    private Node head; // указывает головной узел LinkedList
    private Node last; // указывает на хвостовой узел LinkedList

    public ListImpl() {
        head = new Node(last,null, null);
        last = new Node(null, null, head);
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
        Node temp = head;

        @Override
        public boolean hasNext() {
            return temp == null;
        }

        @Override
        public Object next() {
            return temp.currentElement;
        }

    }

    @Override
    public void addFirst(Object element) {

        final Node f = head;
        final ListImpl.Node newNode = new ListImpl.Node(null, element, f);
        head = newNode;
        if (f == null) {
            last = newNode;
        } else {
            head.prevElement = newNode;
            size++;
        }
            return;
    }


//        Node next = new Node();
//        next.setCurrentElement(element);
//        firstNode = new Node(null, null, next);
//        next.setCurrentElement(firstNode);
//        size++;

    @Override
    public void addLast(Object element) {
//        Node prev = lastNode;
//        prev.setCurrentElement(element);
//        lastNode = new Node(null, prev, null);
//        prev.setNextElement(lastNode);
//        size++;
        final Node l = last;
        final ListImpl.Node newNode = new ListImpl.Node(null, element, l);
        last = newNode;
        if (l == null)
            head = newNode;
        else
            l.nextElement = newNode;
        size++;
    }

    @Override
    public void removeFirst() {
        final ListImpl.Node next = head;
        if (next == null)
            throw new NoSuchElementException();

        final ListImpl.Node f1 = next.nextElement;
        next.nextElement = null;
        head = f1;
        if (f1 == null)
            last = null;
        else
            f1.prevElement = null;
        size--;
    }

    @Override
    public void removeLast() {
        final ListImpl.Node l = last;
        if (l == null)
            throw new NoSuchElementException();
        final ListImpl.Node prev = l.prevElement;
        prev.prevElement = null;
        last = prev;
        if (prev == null)
            head = null;
        else
            prev.nextElement = null;
        size--;
    }

    @Override
    public Object getFirst() {
        final ListImpl.Node f = head;
        if (f == null)
            throw new NoSuchElementException();
        return f.currentElement;
    }

    @Override
    public Object getLast() {
        final ListImpl.Node l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.currentElement;
    }

    @Override
    public Object search(Object element) {
        if (head == null) {
            return null;
        }
        Node currNode = head;
        if (element == null) {
            while (currNode.nextElement != null) {
                if (currNode.prevElement == null) {
                    return null;
                }
                currNode = currNode.nextElement;
            }
            if (currNode.prevElement == null) {
                return null;
            }
            return null;
        } else {
            while (currNode.nextElement != null) {
                if (currNode.prevElement.equals(element)) {
                    return currNode.prevElement;
                }
                currNode = currNode.nextElement;
            }
            if (element.equals(currNode.prevElement)) {
                return currNode.prevElement;
            }
            return null;
        }
    }

    @Override
    public boolean remove(Object element) {
//        if (element == null) {
//            for (ListImpl.Node x = head; x != null; x = x.nextElement) {
//                if (x.currentElement == null) {
//                    unlink(x);
//                    return true;
//                }
//            }
//        } else {
//            for (LinkedList.Node<E> x = first; x != null; x = x.next) {
//                if (o.equals(x.item)) {
//                    unlink(x);
//                    return true;
//                }
//            }
//        }
//        return false;
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
