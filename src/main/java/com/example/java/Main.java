package com.example.java;

public class Main {
    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();

        list.append('1');
        list.append('2');
        list.append('3');
        list.append('4');
        list.printList();

        System.out.println("Довжина списку: " + list.length());
        list.insert('a', 2);
        list.printList();

        char res = list.delete(2);
        System.out.println(res);
        list.printList();

        list.append('e');
        list.append('e');
        list.append('e');
        list.append('e');
        list.printList();
        list.deleteAll('e');
        list.printList();

        System.out.println(list.get(2));

        DoublyLinkedList list2 = list.clone();
        list2.printList();

        System.out.println("123123123");
        list2.reverse();
        list2.printList();
        System.out.println(list2.head.data);

        System.out.println(list2.findFirst('1'));
        System.out.println(list2.findFirst('9'));

        list2.insert('1', 0);
        list2.printList();
        System.out.println(list2.findLast('1'));
        System.out.println(list2.findLast('9'));

        list2.clear();
        System.out.println("lalala");
        list2.printList();
        System.out.println("lalala");

        list2.append('9');
        list2.append('9');
        list2.append('9');
        list.extend(list2);
        list.printList();
    }
}