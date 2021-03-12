package com.yogesh.Heaps;

public class MaxHeap {
    //Heapify is the process of creating a heap data structure from a binary
    //tree. It is used to create a Min-Heap or a Max-Heap.

    public static void heapify(int[] array) {
        //Loop over the array passed as parameter, anf for each item
        //Make sure the item is right position, otherwise we have to bubble it down
        var lastParentIndex = array.length /2 - 1;
        for (var i = lastParentIndex; i >= 0; i--)
            //for each iteration heapify item at given index
            heapify(array, i);
    }

    private static void heapify(int[] array, int index){
        //check if item is smaller than children, if item is smaller
        //than its children, swap it with larger child
        var largerIndex = index;

        var leftIndex = index * 2 + 1;
        if (leftIndex < array.length && array[leftIndex] > array[largerIndex])
            //reset largest to left index
            largerIndex = leftIndex;

        var rightIndex = index * 2 + 2;
        if (rightIndex < array.length && array[rightIndex] > array[largerIndex])
            //reset largest to right index
            largerIndex = rightIndex;

        //The item is in right place so we simply return, (greater than both the children)
        if (index == largerIndex)
            return;

        //else swap the items
        swap(array, index, largerIndex);
        //recursively go down sub tree until item is in right position
        heapify(array, largerIndex);
    }

    private static void swap(int[] array, int first, int second){
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();

        var heap = new Heap();
        for (var number : array)
            heap.insert(number);

        //to get third largest value, execute delete operation k-1 times
        for (var i = 0; i < k - 1; i++)
            heap.remove();

        //return max heap
        return heap.max();
    }

}
