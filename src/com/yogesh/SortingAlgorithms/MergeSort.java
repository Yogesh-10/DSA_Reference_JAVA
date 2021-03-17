package com.yogesh.SortingAlgorithms;

public class MergeSort {
    public void sort(int[] array){
        //Base condition
        if (array.length < 2)
            return;

        //Divide array to half
        var middle = array.length / 2;

        int[] left = new int[middle]; //set new array to size of middle
        //copy all items all of array up to this point, in left partition.
        for (var i = 0; i < middle; i++)
            left[i] = array[i];

        int[] right = new int[array.length - middle];
        //copy all the items belong to this partition in this partition below.
        for (var i = middle; i < array.length; i++)
            right[i - middle] = array[i];

        //sort each half
        sort(left);
        sort(right);

        //merge the result
        merge(left, right, array);
    }

    private void merge(int[] left, int[] right, int[] result) {
        //iterate over left and right partitions, we read one item at a time,
        //we pick smaller one and store it in result array
        int i = 0, j = 0, k = 0; //i  to iterate left partition, j to right, k to result arr

        while (i < left.length && j < right.length){
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
    }
}
