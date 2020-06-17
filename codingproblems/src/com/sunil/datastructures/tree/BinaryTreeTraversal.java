package com.sunil.datastructures.tree;

/**
 * Debth First Search traversals of binary tree.
 * 1. In Order
 * 2. Pre Order
 * 3. Post Order
 *
 */
public class BinaryTreeTraversal {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);

        BinaryTree.Node two = new BinaryTree.Node(2);
        BinaryTree.Node three = new BinaryTree.Node(3);

        BinaryTree.Node four = new BinaryTree.Node(4);
        BinaryTree.Node five = new BinaryTree.Node(5);

        BinaryTree.Node six = new BinaryTree.Node(6);
        BinaryTree.Node seven = new BinaryTree.Node(7);

        binaryTree.root.left = two;
        binaryTree.root.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        System.out.println("Inorder Traversal");
        inOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("Preorder Traversal");
        preOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.println("Postorder Traversal");
        postOrderTraversal(binaryTree.root);
        System.out.println();
    }

    private static void inOrderTraversal(BinaryTree.Node root) {
        if(root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    private static void preOrderTraversal(BinaryTree.Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void postOrderTraversal(BinaryTree.Node root) {
        if(root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
}
