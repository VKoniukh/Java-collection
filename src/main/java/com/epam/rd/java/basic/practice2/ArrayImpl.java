package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class ArrayImpl implements Array {
    private Integer elementSize = 0;
    // При создании SimpleArrayList, емкость массива по умолчанию 16
    private Integer arrayCapacity = 16;
    // Когда емкости массива недостаточно, размер каждого раскрытия по умолчанию
    private static final Integer DEFUALT_EXPAND_SIZE = 16;
    // Контейнер элемента
    Object[] array = null;

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++)
            array[i] = null;
    }

	@Override
    public int size() {
	    int sum = array.length;
            return sum;
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
