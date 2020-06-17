package com.sunil.datastructures.tree;

/**
 * Check if a given tree is sub tree of another tree.
 */
public class CheckIfSubTreeOfAnotherTree {
    public static void main(String[] args) {
        // Construction of subtree.
        BinaryTree subTree = new BinaryTree(10);

        BinaryTree.Node twenty = new BinaryTree.Node(20);
        subTree.root.left = twenty;

        BinaryTree.Node thirty = new BinaryTree.Node(20);
        subTree.root.right = thirty;

        // Construction of tree.
        BinaryTree tree = new BinaryTree(1);

        BinaryTree.Node two = new BinaryTree.Node(2);
        tree.root.left = two;
        tree.root.right = subTree.root;

        if (isSubTreeOfAnotherTree(tree.root, subTree.root)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isSubTreeOfAnotherTree(BinaryTree.Node tree, BinaryTree.Node subTree) {
        if (subTree == null) {
            return true;
        }

        if (tree == null) {
            return false;
        }

        if (areIdentical(tree, subTree)) {
            return true;
        }
        return areIdentical(tree.left, subTree) || areIdentical(tree.right, subTree);
    }

    private static boolean areIdentical(BinaryTree.Node tree, BinaryTree.Node subTree) {
        if (tree == null && subTree == null) {
            return true;
        }
        if (tree == null || subTree == null) {
            return false;
        }
        return tree.data == subTree.data && areIdentical(tree.left, subTree.left) && areIdentical(tree.right, subTree.right);
    }
}
