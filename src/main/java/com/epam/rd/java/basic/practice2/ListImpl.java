package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImpl implements List {

   Node head; // head of list
    private int size = 0;

    /* Doubly Linked list Node*/
    class Node {
        Object data;
        Node prev;
        Node next;

        // Constructor to create a new node
        // next and prev is by default initialized as null
        Node(Object d) { data = d; }
    }

    // Adding a node at the front of the list
    @Override
    public void addFirst(Object new_data)
    {
        /* 1. allocate node
         * 2. put in the data */
        Node new_Node = new Node(new_data);

        /* 3. Make next of new node as head and previous as NULL */
        new_Node.next = head;
        new_Node.prev = null;

        /* 4. change prev of head node to new node */
        if (head != null)
            head.prev = new_Node;

        /* 5. move the head to point to the new node */
        head = new_Node;
        size++;
    }


    // Add a node at the end of the list
    @Override
    public void addLast(Object new_data)    {
        /* 1. allocate node
         * 2. put in the data */
        Node new_node = new Node(new_data);

        Node last = head; /* used in step 5*/

        /* 3. This new node is going to be the last node, so
         * make next of it as NULL*/
        new_node.next = null;

        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        /* 5. Else traverse till the last node */
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;

        /* 7. Make last node as previous of new node */
        new_node.prev = last;
        size++;
    }


    public static void main(String[] args)
    {
//        TTTT
    }

    @Override
    public void clear() {
        if (size > 0) {
            head = null;
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
            return temp != null;
        }

        @Override
        public Object next() {
            Object data = temp.data;
            temp = temp.next;
            return data;
        }
    }

//    @Override
//    public void addFirst(Object element) {
//
//    }


    @Override
    public void removeFirst() {
        final Node removed = head;
        if (removed == null)
            throw new NoSuchElementException();

        final Node f1 = removed.next;
        removed.next = null;
        head = f1;
        size--;
    }

    @Override
    public void removeLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node prev = temp.prev;
        prev.next = null;
        size--;
    }

    @Override
    public Object getFirst() {
        final Node f = head;
        if (f == null)
            throw new NoSuchElementException();
        return f.data;
    }

    @Override
    public Object getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    @Override
    public Object search(Object element) {
        if (head == null) {
            return null;
        }
        if (element == null) {
            return null;
        }

        Node temp = head;

        // While loop is used to search the entire Linked
        // List starting from the tail
        while (temp != null) {

            // Returns the index of that particular element,
            // if found.
            if (temp.data.equals(element)) {
                return temp.data;
            }

            // Gradually increases index while
            // traversing through the Linked List
            temp = temp.next;
        }

        // Returns -1 if the element is not found
        return null;
//        if (head == null) {
//            return null;
//        }
//        Node currNode = head;
//        if (element == null) {
//            while (currNode.next != null) {
//                if (currNode.prev == null) {
//                    return null;
//                }
//                currNode = currNode.next;
//            }
//            if (currNode.prev == null) {
//                return null;
//            }
//            return null;
//        } else {
//            while (currNode.next != null) {
//                if (currNode.prev.data.equals(element)) {
//                    return currNode.prev.data;
//                }
//                currNode = currNode.next;
//            }
//            if (element.equals(currNode.prev.data)) {
//                return currNode.prev.data;
//            }
//            return null;
//        }
    }

    Object unlink(Node x) {
        // assert x != null;
        final Object element = x.data;
        final Node next = x.next;
        final Node prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        next.prev = prev;
        x.next = null;

        x.data = null;
        size--;
        return element;
    }

    @Override
    public boolean remove(Object element) {
        if (element == null) {
            for (Node x = head; x != null; x = x.next) {
                if (x.data == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node x = head; x != null; x = x.next) {
                if (element.equals(x.data)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node temp = head;
        while (temp != null) {
            sb.append(temp.data + ", ");
            temp = temp.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}
