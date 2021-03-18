package com.yogesh.SortingAlgorithms;

public class QuickSort {
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end) {
        //Base condition
        if (start >= end)
            return;

        //partition
        var boundary = partition(array, start, end);
        //sort left
        sort(array, start, boundary - 1);
        //sort right
        sort(array, boundary + 1, end);
    }

    private int partition(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1; //left partition is empty and right partition is zero
        //iterate over array and if we find item smaller than pivot put in left partition,
        //to do that increment boundary and swap
        for (int i = start; i <= end; i++)
            if (array[i] <= pivot){
                boundary++;
                swap(array, i, boundary);
            }
        return boundary;
    }

    private void swap(int[] array, int index1, int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
