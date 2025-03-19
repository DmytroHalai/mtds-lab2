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
}
