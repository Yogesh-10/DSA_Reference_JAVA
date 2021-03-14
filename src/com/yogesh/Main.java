package com.yogesh;

import com.yogesh.SortingAlgorithms.BubbleSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {  };
        var sorter = new BubbleSort();
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}