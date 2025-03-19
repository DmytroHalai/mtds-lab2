package com.example.java;

public class DoublyLinkedList {
    public Node head;
    public Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public int length() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public void append(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insert(char element, int index) throws Exception {
        checkIndex(index);
        Node newNode = new Node(element);

        if (index == 0) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } else if (index == length()) {
            if (tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        } else {
            Node current = head;
            int curentIndex = 0;
            while (curentIndex < index) {
                current = current.next;
                curentIndex++;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            if (current.prev != null) {
                current.prev.next = newNode;
            }
            current.prev = newNode;
        }
    }

    public void checkIndex(int index) throws Exception {
        if (index < 0 || index > length()) {
            throw new Exception("Index is not valid");
        }
    }

    public char delete(int index) throws Exception {
        checkIndex(index);
        char result;
        Node current = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        result = current.data;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        return result;
    }

    public void deleteAll(char el) {
        Node current = head;
        while (current != null) {
            if (current.data == el) {
                if (current.prev == null) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current.next == null) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
            }
            current = current.next;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public char get(int index) throws Exception {
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
        Node temp = null;
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

}
