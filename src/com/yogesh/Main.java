package com.yogesh;

import com.yogesh.SortingAlgorithms.SelectionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 7, 4, 3, 8, 9, 1 };
        var sorter = new SelectionSort();
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}