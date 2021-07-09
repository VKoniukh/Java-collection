package com.epam.rd.java.basic.practice2;

import java.util.Iterator;

public class Demo {

    public static void main(String[] args) {
        Stack objects  = new StackImpl();
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
        objects.top ();
        objects.toString();
        objects.clear();
        objects.pop();
        objects.size();
        objects.push (5);
        System.out.println(objects.size());
        System.out.println( objects.pop());
        System.out.println(objects.toString());
        System.out.println(objects.top());
    }
}
