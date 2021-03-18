package com.yogesh;

import com.yogesh.SortingAlgorithms.CountingSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 4, 1, 3, 0, 4 };
        var sorter = new CountingSort();
        sorter.sort(arr, 4);
        System.out.println(Arrays.toString(arr));
    }
}