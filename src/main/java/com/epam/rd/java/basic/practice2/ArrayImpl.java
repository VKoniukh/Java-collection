package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class ArrayImpl<T> implements Array {
    private int index = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elementData;

    public ArrayImpl(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
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
        if (size == elementData.length) {
            Object[] temp = new Object[(elementData.length * 2)];
            System.arraycopy(elementData, 0, temp, 0, elementData.length);
            elementData = temp; //вызываем метод, который отвечает за увеличение массива
        }
        elementData[size] = element; //записываем в конец списка новое значение
        size++;  //увеличиваем значение переменной размера списка
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
