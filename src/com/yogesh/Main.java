package com.yogesh;

import com.yogesh.SortingAlgorithms.InsertionSort;
import com.yogesh.SortingAlgorithms.MergeSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 7, 4, 3, 8, 9, 1 };
        var sorter = new MergeSort();
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}