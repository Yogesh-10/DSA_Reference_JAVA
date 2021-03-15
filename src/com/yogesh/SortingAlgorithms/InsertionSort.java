package com.yogesh.SortingAlgorithms;

public class InsertionSort {
    public void sort(int[] array) {
        //We start from i=1, because we assume item is in correct position
        for (var i = 1; i < array.length; i++){
            var current = array[i];
            var j = i - 1; // we start from prev item.
            while (j >= 0 && array[j] > current) {
                //shifting greater items to right side
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
}
