package com.yogesh;

import com.yogesh.SearchingAlgorithms.BinarySearch;
import com.yogesh.SearchingAlgorithms.JumpSearch;
import com.yogesh.SearchingAlgorithms.TernarySearch;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        var search = new JumpSearch();
        var index = search.jumpSearch(arr, 6);
        System.out.println(index);
    }
}