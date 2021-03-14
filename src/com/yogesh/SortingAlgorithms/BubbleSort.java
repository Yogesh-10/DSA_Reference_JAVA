package com.yogesh.SortingAlgorithms;

public class BubbleSort {
    public void sort(int[] array) {
        //If array is already sorted or partially sorted, we dont need
        //n iteration we nee only fewer iterations, so we can optimize code
        boolean isSorted;

        //In each iteration, next largest item will bubble up and
        //Move to its correct position
        for (var i = 0; i < array.length; i++) {
            isSorted = true; //assuming array is sorted
            //in above, first iteration, no items are in correct position,
            //but in second iteration below, one of item is sorted, so we look
            //all items except last item, so (array.length - i), bcoz in first iteration,
            //i is 0, in second iteration i is 1, so we skip last item
            for (var j = 1; j < array.length - i; j++)
                //If element in array is smaller than previous item, swap them
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            //if array is already sorted, we no need any iterations
            if (isSorted)
                return;
        }
    }

    private void swap(int[] array, int index1, int index2){
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
