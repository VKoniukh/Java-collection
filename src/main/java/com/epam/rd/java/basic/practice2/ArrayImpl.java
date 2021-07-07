package com.epam.rd.java.basic.practice2;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {
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

    private class IteratorImpl implements Iterator<Object> {
        int cursor;
        int lastRet = -1;

        IteratorImpl() {
        }

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Object next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = ArrayImpl.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (Object) elementData[lastRet = i];
        }

    }


    @Override
    public void add(Object element) {
        Object[] arrCopy = new Object[this.size + 1];
        for (int i = 0, j = 0; i < this.size; i++, j++) {
            arrCopy[j] = elementData[i];
        }
        arrCopy[this.size] = element;
        ++this.size;
        elementData = arrCopy;
    }


    @Override
    public void set(int index, Object element) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Element can't be found! ");
        } else {
            elementData[index] = element;
        }
    }

    @Override
    public Object get(int index) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return (Object) elementData[index];
    }

    @Override
    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (element.equals(elementData[i]))
                    return i;
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        if (size == 0) {
            sb.append("]");
            return sb.toString();
        } else {
            for (int i = 0; i < size; i++) {
                sb.append(elementData[i] + "").append(", ");
            }
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) {
        //Can test classes here

    }

}
