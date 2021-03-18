package com.yogesh;

import com.yogesh.SearchingAlgorithms.BinarySearch;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        var search = new BinarySearch();
        var index = search.binarySearchIterative(arr, 1);
        System.out.println(index);
    }
}