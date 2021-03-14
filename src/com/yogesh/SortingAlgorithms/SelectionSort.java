package com.yogesh.SortingAlgorithms;

public class SelectionSort {
    public void sort(int[] array) {
        for (var i = 0; i < array.length; i++){
            //In each iteration find next min value index
            var minIndex = i;
            //we iterate over this array, in every iteration we find next
            //min value in unsorted array, that is why we set j=i in for loop
            for (var j = i; j < array.length; j++)
                //If item at j is small than minIndex, reset minIndex to j
                if (array[j] < array[minIndex])
                    minIndex = j;

            //After this for loop, we have index of next smallest item,
            //so we need to do a swap
            swap(array, minIndex, i);
        }
    }

    private void swap(int[] array, int index1, int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
