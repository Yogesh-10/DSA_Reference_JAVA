package com.yogesh.SortingAlgorithms;

public class CountingSort {
    public void sort(int[] array, int max) {
        int[] counts = new int[max + 1]; //max + 1 because, in counts array we have 0 to 5, so we add 1 to it
        for (var item : array)
            //we use item as index in counts array.
            counts[item]++;

        int k = 0; //indexer variable
        for (var i = 0; i < counts.length; i++)
            for (var j = 0; j < counts[i]; j++)
                array[k++] = i;
    }
}
