package com.epam.rd.java.basic.practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ArrayImpl <E> implements Array {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private int size;
    transient Object[] elementData;

    public ArrayImpl(Collection<? extends E> c) {
        Object[] a = c.toArray();
        if ((size = a.length) != 0) {
            if (c.getClass() == ArrayList.class) {
                elementData = a;
            } else {
                elementData = Arrays.copyOf(a, size, Object[].class);
            }
        } else {
            // replace with empty array.
            elementData = EMPTY_ELEMENTDATA;
        }
    }

    protected transient int modCount = 0;

    @Override
    public void clear() {
        modCount++;

        // clear to let GC do its work
        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }

	@Override
    public int size() {
        return size;
    }
	
	@Override
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
    public void add(Object element) {

    }

	@Override
    public void set(int index, Object element) {
        
    }

	@Override
    public Object get(int index) {
        return null;
    }

	@Override
    public int indexOf(Object element) {
        return 0;
    }

	@Override
    public void remove(int index) {
        
    }

    @Override
    public String toString() {
        return null;
    }

    public static void main(String[] args) {

    }

}
