package com.example.java;

import java.util.ArrayList;

public class DoublyLinkedList {
    private ArrayList<Character> list;

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
        for (Character c : list) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public char get(int index){
        return list.get(index);
    }

    public DoublyLinkedList clone() {
        DoublyLinkedList clonedList = new DoublyLinkedList();
        clonedList.list = new ArrayList<>(list);
        return clonedList;
    }

    public void reverse(){
        ArrayList<Character> reversedList = new ArrayList<>();
        for (int i = length() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        list = reversedList;
    }

    public int findFirst(char el){
        return list.indexOf(el);
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
