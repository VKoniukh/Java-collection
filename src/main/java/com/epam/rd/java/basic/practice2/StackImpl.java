package com.epam.rd.java.basic.practice2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Stack {
    public int size = 0;
    public int arrayCapacity = 16;
    Object[] elementData;

    public void StackImpl() {
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
        if (isFull()) {
            enlarge();

        }
        size++;
        // Добавить элемент в начало стека
        elementData[size - 1] = element;
    }

    public boolean isFull() {

        return elementData.length == size;
    }


    public void enlarge() {
        Object[] newData = (Object[]) new Object[elementData.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = elementData[i];

        }
        elementData = newData;
    }


    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object element = elementData[size - 1];
        elementData[size] = null;
        size--;
        return element;
    }

    public boolean isEmpty() {
        return size < 1;
    }

    @Override
    public Object top() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elementData[size-1];
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
                    sb.append(elementData[i]);
                } else {
                    sb.append(elementData[i]).append(", ");
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
