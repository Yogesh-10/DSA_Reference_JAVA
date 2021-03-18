package com.yogesh;

import com.yogesh.SortingAlgorithms.BucketSort;
import com.yogesh.SortingAlgorithms.CountingSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = { };
        var sorter = new BucketSort();
        sorter.sort(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}