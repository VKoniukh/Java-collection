package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class ArrayImpl <element> implements Array {
    public int size = 0;
    public int arrayCapacity = 16;
    public static final Integer DEFUALT_EXPAND_SIZE = 16;
    public int index = 0;

    Object[] elementData = null;

    public ArrayImpl() {
        this(DEFUALT_EXPAND_SIZE);
    }

    public ArrayImpl(int arrayCapacity) {
        super();
        if (arrayCapacity > 0) {
            elementData = new Object[arrayCapacity];
            this.arrayCapacity = arrayCapacity;
        } else {
            throw new IllegalArgumentException("Пространство массива вне границ");
        }
    }


    @Override
    public void clear() {

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

    private class IteratorImpl implements Iterator {

        private int index = 0;
        Object[] values;

        IteratorImpl() {
            this.values = values;
        }

        @Override
        public boolean hasNext() {
            return index < values.length;
        }

        @Override
        public Object next() {
            return values[index++];
        }

    }

    @Override
    public void add(Object element) {
        if (size < elementData.length) {
            elementData[size++] = element;
        } else {
            arrayCapacity += DEFUALT_EXPAND_SIZE;
            Object[] temp = new Object[(elementData.length * 2)];
            System.arraycopy(elementData, 0, temp, 0, elementData.length);
            elementData = temp;
            elementData[size++] = element;
        }
        size++;
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
