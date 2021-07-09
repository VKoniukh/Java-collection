package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {

    public void StackImpl() {
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
            return true;
        }

        @Override
        public Object next() {
            return true;
        }

    }

    @Override
    public void push(Object element) {
    }


    @Override
    public Object pop() {
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
