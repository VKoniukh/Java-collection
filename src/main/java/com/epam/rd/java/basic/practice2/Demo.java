package com.epam.rd.java.basic.practice2;


import java.util.Iterator;

public class Demo {

    public static void main(String[] args) {
        ArrayImpl objects = new ArrayImpl(2);
//        System.out.println(objects.size);
//        System.out.println(objects.index);
        objects.add("A");
        objects.add("b");
        objects.add("c");
        objects.add(null);
        System.out.println(objects.toString());
        Iterator<Object> iterator = objects.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
    }
}
