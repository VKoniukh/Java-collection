package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

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
        //return new IteratorImpl();
        Iterator<Object> it = new Iterator<Object>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && elementData[currentIndex] != null;
            }

            @Override
            public Object next() {
                return elementData[currentIndex++];
            }

        };
        return it;
    }

    @Override
    public void add(Object element) {
//        Object[] arrCopy = new Object[this.size + 1];
//        for (int i = 0, j = 0; i < this.size; i++, j++) {
//            arrCopy[j] = elementData[i];
//        }
//        arrCopy[this.size] = element;
//        ++this.size;
//        elementData = arrCopy;
        if (size < elementData.length) {
            elementData[size++] = element;
        } else {
            Object[] temp = new Object[(elementData.length * 2)];
            System.arraycopy(elementData, 0, temp, 0, elementData.length);
            elementData = temp;
            elementData[size++] = element;
        }
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

//    public static void main(String[] args) {
//        //Can test classes here
//
//    }

}
