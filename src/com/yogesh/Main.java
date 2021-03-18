package com.yogesh;

import com.yogesh.SearchingAlgorithms.BinarySearch;
import com.yogesh.SearchingAlgorithms.TernarySearch;

public class Main {
    public static void main(String[] args) {
        int[] arr = {  };
        var search = new TernarySearch();
        var index = search.ternarySearch(arr, 9);
        System.out.println(index);
    }
}