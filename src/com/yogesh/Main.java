package com.yogesh;

import com.yogesh.SearchingAlgorithms.LinearSearch;
import com.yogesh.SortingAlgorithms.BucketSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 9, 8, 9, 7, 6, 5, 4 };
        var search = new LinearSearch();
        var index = search.linearSearch(arr, 9);
        System.out.println(index);
    }
}