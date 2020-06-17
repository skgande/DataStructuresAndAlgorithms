package com.sunil.datastructures.tree;

/**
 * Verify given tree is binary search tree or not.
 *
 * Binary search tree is a binary tree where left node is less than root node and right node is higher than root node.
 */
public class IsBinarySearchTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(4);

        BinaryTree.Node four = binaryTree.root;
        BinaryTree.Node one = new BinaryTree.Node(1);
        BinaryTree.Node two = new BinaryTree.Node(2);
        BinaryTree.Node three = new BinaryTree.Node(3);
        BinaryTree.Node five = new BinaryTree.Node(5);

        four.left = two;
        four.right = five;

        two.left = one;
        two.right = three;

        if(verifyBinarySearchTree(four, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("Given tree is binary search tree");
        } else {
            System.out.println("Given tree is not a binary search tree");
        }
    }

    private static boolean verifyBinarySearchTree(BinaryTree.Node node, int min, int max) {
        if(node == null) {
            return true;
        }

        if(node.data < min || node.data > max) {
            return false;
        }

        return verifyBinarySearchTree(node.left, min, node.data - 1) &&
                verifyBinarySearchTree(node.right, node.data + 1, max);
    }
}
