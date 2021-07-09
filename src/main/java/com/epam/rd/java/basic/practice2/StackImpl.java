package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {
    private final int DEFAULT_CAPACITY = 100;
    private int top;  // indicates the next open slot
    private transient Object[] stack;
    private int size;

    public void StackImpl() {
        top = 0;
        stack = (Object[]) (new Object[DEFAULT_CAPACITY]);
        int size = DEFAULT_CAPACITY;
    }

    @Override
    public void clear() {
        for (int i = 0; i < top; i++)
            stack[i] = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<Object> {
        private Iterator<Object> iterator;

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Object next() {
            return iterator.next();
        }

    }

    @Override
    public void push(Object element) {
        if (size() == stack.length)
            expandCapacity();

        stack[top] = element;
        top++;

//        if (isFull()) {
//            enlarge();
//        }
//        size++;
//        // Добавить элемент в начало стека
//        elementData[size - 1] = element;
    }

    public boolean isFull() {
        return stack.length == size;
    }


    private void expandCapacity() {
        Object[] larger = (Object[]) (new Object[stack.length * 2]);

        for (int index = 0; index < stack.length; index++)
            larger[index] = stack[index];

        stack = larger;
    }


    @Override
    public Object pop() {
        if (isEmpty())
            throw new NoSuchElementException();
        top--;
        Object result = stack[top];
        stack[top] = null;
        return result;
    }




    public boolean isEmpty() {
        return size < 1;
    }

    @Override
    public Object top() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return stack[size - 1];
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (size == 0) {
            sb.append("]");
            return sb.toString();
        } else {
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    sb.append(stack[i]);
                } else {
                    sb.append(stack[i]).append(", ");
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
