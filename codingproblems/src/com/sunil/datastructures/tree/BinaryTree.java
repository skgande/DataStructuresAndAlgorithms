package com.sunil.datastructures.tree;

/**
 *  Binary tree representation to store data in hierarchical structure.
 */
public class BinaryTree {
    Node root;
    BinaryTree(int data) {
        this.root = new Node(data);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
