package com.sunil.datastructures.linkedlist;

/**
 * Program to perform basic operations of linked list.
 */
public class LinkedList {
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        one.next = two;
        two.next = three;

        LinkedList linkedList = new LinkedList();
        linkedList.head = one;

        printLinkedList(linkedList.head);

        // Insert at the beginning.
        Node zero = new Node(0);
        linkedList.head = insertNodeAtBeginning(zero, linkedList.head);
        printLinkedList(linkedList.head);

        // Insert at the end.
        Node four = new Node(4);
        insertNodeAtEnd(four, linkedList.head);
        printLinkedList(linkedList.head);

        // Insert five after two.
        Node five = new Node(5);
        insertAfterSpecifiedNode(five, two, linkedList.head);
        printLinkedList(linkedList.head);
    }

    private static void printLinkedList(Node node) {
        System.out.println("============ PRINTING LINKED LIST =============");
        while (node != null) {
            if(node.next == null) {
                System.out.println(node.data);
                break;
            }
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("============ END OF LINKED LIST ===============");
    }

    private static Node insertNodeAtBeginning(Node node, Node head) {
        node.next = head;
        return node;
    }

    private static void insertNodeAtEnd(Node node, Node start) {
        while (start.next != null) {
            start = start.next;
        }
        start.next = node;
    }

    private static void insertAfterSpecifiedNode(Node newNode, Node afterNode, Node first) {
        while (first != null) {
            if (first.data == afterNode.data) {
                Node temp = afterNode.next;
                first.next = newNode;
                newNode.next = temp;
            }
            first = first.next;
        }
    }
}
