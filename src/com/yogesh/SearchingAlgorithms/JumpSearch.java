package com.yogesh.SearchingAlgorithms;

public class JumpSearch {
    public int jumpSearch(int[] array, int target) {
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int next = blockSize;

        //move the pointer and find the block where target item is existing
        while (start < array.length && array[next - 1] < target) {
            start = next;
            next+= blockSize;
            //check if next becomes too big, if yes, reduce it to size of array
            if (next > array.length)
                next = array.length;
        }

        //do a linear search in that block to find target
        for (var i = start; i < next; i++)
            if (array[i] == target)
                return i;

        return -1;

    }
}
