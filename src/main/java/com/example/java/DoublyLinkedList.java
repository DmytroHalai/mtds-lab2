package com.example.java;

import java.util.ArrayList;

public class DoublyLinkedList {
    private final ArrayList<Character> list;

    public DoublyLinkedList() {
        list = new ArrayList<>();
    }

    public int length() {
        return list.size();
    }

    public void append(char data) {
        list.add(data);
    }

    public void insert(char element, int index){
        checkIndex(index);
        list.add(index, element);
    }

    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > length()) {
            throw new IndexOutOfBoundsException("Index is not valid");
        }
    }

    public char delete(int index){
        checkIndex(index);
        return list.remove(index);
    }

    public void deleteAll(char el) {
        list.removeIf(c -> c == el);
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public char get(int index){
        checkIndex(index);
        Node current = head;
        int currentIndex = 0;
        while (currentIndex != index) {
            current = current.next;
            currentIndex++;
        }
        return current.data;
    }

    public DoublyLinkedList clone() {
        DoublyLinkedList clonedList = new DoublyLinkedList();
        if (head == null) {
            return clonedList;
        }
        Node current = head;
        while (current != null) {
            clonedList.append(current.data);
            current = current.next;
        }
        return clonedList;
    }

    public void reverse(){
        if (head == null) return;
        Node current = head;
        Node temp;
        while (current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        temp = head;
        head = tail;
        tail = temp;
    }

    public int findFirst(char el){
        Node current = head;
        int currentIndex = 0;
        while (current != null){
            if (current.data == el){
                return currentIndex;
            }
            current = current.next;
            currentIndex++;
        }
        return -1;
    }

    public int findLast(char el) {
        Node current = tail;
        int currentIndex = length()-1;
        while (current != null){
            if (current.data == el){
                return currentIndex;
            }
            current = current.prev;
            currentIndex--;
        }
        return -1;
    }

    public void clear(){
        head = null;
    }

    public void extend(DoublyLinkedList list2) {
        if (list2.head == null) {
            return;
        }
        Node list1Tail = tail;
        Node list2Head = list2.head;
        while (list2Head != null) {
            Node newNode = new Node(list2Head.data);
            list1Tail.next = newNode;
            newNode.prev = list1Tail;
            list1Tail = newNode;
            list2Head = list2Head.next;
        }
        tail = list1Tail;
    }

}
