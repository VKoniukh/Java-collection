package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class Demo {

    public static void main(String[] args) {
        List objects = new ListImpl();
        /* Start with the empty list */
//        DLL dll = new DLL();
//
//        // Insert 6. So linked list becomes 6->NULL
//        dll.append(6);
//
//        // Insert 7 at the beginning. So
//        .. linked list becomes 7->6->NULL
//        dll.push(7);
//
//        // Insert 1 at the beginning. So
//        // linked list becomes 1->7->6->NULL
//        dll.push(1);
//
//        // Insert 4 at the end. So linked
//        // list becomes 1->7->6->4->NULL
//        dll.append(4);
//
//        // Insert 8, after 7. So linked
//        // list becomes 1->7->8->6->4->NULL
//        dll.InsertAfter(dll.head.next, 8);
//
//        System.out.println("Created DLL is: ");
//        dll.printlist(dll.head);
        objects.addFirst("A");
        objects.addFirst("b");
        objects.addLast("c");
        System.out.println(objects.size());
        System.out.println( objects.getFirst());
        System.out.println( objects.getLast());
        System.out.println(objects.toString());
        System.out.println(objects.search("z"));
        System.out.println(objects.toString());
        objects.addLast(null);
        System.out.println(objects.toString());
        objects.remove(null);
        System.out.println(objects.toString());
        Iterator<Object> iterator = objects.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
    }
}
