package com.yogesh.SearchingAlgorithms;

public class ExponentialSearch {
    public int exponentialSearch(int[] array, int target) {
        int bound = 1;

        //as long as last item in this range is smaller than target value
        //we should double the bound
        while (bound < array.length && array[bound] < target)
            bound *= 2;

        //do a binary search in this range
        var binarySearch = new BinarySearch();

        int left = bound / 2;
        int right = Math.min(bound, array.length -1);
        return binarySearch.binarySearchRecursive(array, target, left, right);
    }
}
