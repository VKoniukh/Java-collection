package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class StackImpl implements Stack {

    private Object arr[];
    private int top;
    private int capacity;

    StackImpl(int size) {
        arr = new Object[size];
        capacity = size;
        top = -1;
    }


    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return top + 1;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < top + 1;
            }

            @Override
            public Object next() {
                return arr[currentIndex++];
            }
        }

    @Override
    public void push(Object element) {
        if (isFull()) {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(1);
        }
        System.out.println("Inserting " + element);
        arr[++top] = element;
    }

    public Boolean isFull() {
        return top == capacity - 1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    @Override
    public Object pop() {
        {
            if (isEmpty()) {
                System.out.println("Underflow\nProgram Terminated");
                System.exit(1);
            }

            System.out.println("Removing " + peek());
            
            return arr[top--];
        }
    }

    public Object peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            System.exit(1);
        }

        return -1;
    }

    @Override
    public Object top() {
        return top + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (top + 1 == 0) {
            sb.append("]");
            return sb.toString();
        } else {
            for (int i = 0; i < top + 1; i++) {
                if (i == top + 1 - 1) {
                    sb.append(arr[i]);
                } else {
                    sb.append(arr[i]).append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        //Can test classes here
    }

}
