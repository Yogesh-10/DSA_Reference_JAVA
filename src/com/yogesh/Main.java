package com.yogesh;

import com.yogesh.SortingAlgorithms.QuickSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 4 };
        var sorter = new QuickSort();
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}