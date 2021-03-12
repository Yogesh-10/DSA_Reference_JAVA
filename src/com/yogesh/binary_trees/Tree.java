package com.yogesh.binary_trees;

import java.util.ArrayList;

//Binary Search Tree Implementation
public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value) {
        //If tree is empty, set root to Node
        if (root == null) {
            root = new Node(value);
            return;
        }

        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = new Node(value);
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = new Node(value);
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    //PRE-ORDER Traversal(Root, Left, Right) -> with(Recursion)
    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        //Base condition
        if (root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    //IN-ORDER Traversal(Left, Root, Right) -> with(Recursion)
    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    //POST-ORDER Traversal(Left, Right, Root) -> with(Recursion)
    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        traverseInOrder(root.rightChild);
        System.out.println(root.value);
    }

    //Find the height of a Tree.
    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;
        //Formula -> 1 + max(height(L), height(R))
        return 1 + Math.max(height(root.leftChild),
                height(root.rightChild));
    }

    private boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
    }

    //Find the min value in a Tree
    //This algorithm is for binary tree, not for binary search tree
    public int min(){
        return min(root);
    }

    //This algorithm is for binary tree, not for binary search tree
    private int min(Node root) {
        //If we get to leaf node, return val of that node itself
        if (isLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        //Return min of three values(left, right, root) -> this is post order
        // traversal, because we start from leaf and go up to the root node.
        return Math.min(Math.min(left, right), root.value);
    }

    //This algorithm is for binary search tree, not for binary tree
    public int minBST(){
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    //Find two Trees are equal
    public boolean equals(Tree other){
        if (other == null)
            return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second){
        if (first == null && second == null)
            return true;

        if (first != null && second != null)
            return first.value == second.value //root Node of both trees
                   && equals(first.leftChild, second.leftChild)
                   && equals(first.rightChild, second.rightChild);

        return false;
    }

    //Validate whether tree is Binary Search Tree
    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max){
        if (root == null)
            return true;

        if (root.value < min || root.value > max)
            return false;

        //If we have root as 20, left child should have max of 19(root.value - 1)
        //If we have root as 20, right child should have at least 21 or greater(root.value + 1)
        return isBinarySearchTree(root.leftChild, min, root.value - 1)
        &&  isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    //Find the Nodes at K Distance from the Root
    public ArrayList<Integer> getNodesAtDistance(int distance){
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list){
        if (root == null)
            return;

        if (distance == 0){
            list.add(root.value);
            return;
        }

        //If distance > 0, recursively traverse the tree, look at left and right
        // children, as we go down tree, we decrement distance by 1.
        getNodesAtDistance(root.leftChild, distance-1, list);
        getNodesAtDistance(root.rightChild, distance-1, list);
    }

    //Level Order Traversal
    public  void traverseLevelOrder(){
        for (var i = 0; i <= height(); i++) {
            var list = getNodesAtDistance(i);
            for (var value : list)
                System.out.println(value);
        }
    }
}

