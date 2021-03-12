package com.yogesh.AVLTree;

public class AVLTree {
    private class AVLNode{
        private int height;
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + this.value;
        }
    }

    private AVLNode root;

    public void insert(int value){
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value){
        if (root == null)
            return new AVLNode(value);

        //first we recursively go down the tree and find a place to insert new node,
        //once done, then we recursively go back up the tree, on the way up, we update
        //the height of every node until we get to root node

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        //Calculate height of the node
        //In above step after we set newNode to child of root node the height changes
        //so, Reset Height of root node,
        root.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;

        root = balance(root);

        //returning root to public insert() method
        return root;
    }

    private AVLNode balance(AVLNode root){
        //Find Tree is Balanced
        //BalanceFactor = height(Left sub tree) - height(Right sub tree) => result should
        // be less than or equal to 1. If diff is greater than 1, it is left heavy, then perform Right rotation
        //If diff is lesser than -1, it is right heavy, then perform left rotation
        //Empty tree is balanced, its balanceFactor is zero
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
                //System.out.println("Left rotate " + root.leftChild.value);
            //If root is left heavy always perform right rotate on root node
            //System.out.println("Right Rotate " + root.value);
            return rotateRight(root);
        }
        else if (isRightHeavy(root)){
            if (balanceFactor(root.rightChild) > 0)
                //System.out.println("Right Rotate " + root.rightChild.value);
                root.rightChild = rotateRight(root.rightChild);
            //If root is right heavy always perform left rotate on root node
            //System.out.println("Left Rotate " + root.value);
            return rotateLeft(root);
        }
        //If we get here, our root is in balance,
        return root;
    }

    private AVLNode rotateLeft(AVLNode root){
        //Rotation
        var newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        //reset height of these two above nodes
        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root){
        var newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node){
        node.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
    }

    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node){
        //Empty tree is balanced, its balanceFactor is zero, so we return zero for empty tree
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private int height(AVLNode node){
        if (node == null)
            return -1; //because height of an empty tree is negative 1
        return node.height;

        //(or)
        //return (node == null) ? -1 : node.height;
    }
}
