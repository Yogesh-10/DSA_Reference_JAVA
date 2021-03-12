package com.yogesh.Heaps;

public class Heap {
    private int[] items = new int[10];
    private int size; //keep track of no.of items in heap.

    public void insert(int value){
        if (isFull())
            throw new IllegalStateException();

        //store value in next available slot
        items[size++] = value;

        bubbleUp();
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        var root = items[0];
        //Move value of last node in to root node
        items[0] = items[--size];

        bubbleDown();

        return root;
    }

    private void bubbleDown() {
        //if item at root is smaller than children, bubble it down until
        //it is in right position
        var index = 0;
        while (index <= size && !isValidParent(index)) {
            //If item at current index is not valid parent, then we have
            //to swap with one of the children(Larger one)
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            //reset index to largerChildIndex because we continuously bubble
            // down this item if its smaller than its children
            index = largerChildIndex;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        //if we dont have right child, return index of left child
        if (!hasRightChild(index))
            return leftChildIndex(index);

        //otherwise, compare and return index of largerChild
        return (leftChild(index) > rightChild(index)) ?
                leftChildIndex(index) :
                rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        //get index of left child and make sure this value is
        // less than or equal to no.of items in heap, so it is valid index
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        //get index of right child and make sure this value is
        // less than or equal to no.of items in heap, so it is valid
        return rightChildIndex(index) <= size;
    }

    //A Node is valid parent, if it is greater than equal to
    //both its children
    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        var isValid = items[index] >= leftChild(index);

        if (hasRightChild(index))
            isValid &= items[index] >= rightChild(index);

        return isValid;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    public boolean isFull() {
        return size == items.length;
    }

    private void bubbleUp() {
        //Bubble-up operation
        //If newItem > parent, we must bubble up this item until it is in right position
        var index = size - 1; //index of last item
        while (index > 0 && items[index] > items[parent(index)]){
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second){
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public int max(){
        if (isEmpty())
            throw new IllegalStateException();

        return items[0];
    }
}
