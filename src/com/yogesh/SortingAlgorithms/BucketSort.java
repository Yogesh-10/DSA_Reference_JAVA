package com.yogesh.SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public void sort(int[] array, int numberOfBuckets) {
        var buckets = createBuckets(array, numberOfBuckets);

        //now iterate over different buckets and refill input array
        var i = 0;
        for (var bucket : buckets){
            Collections.sort(bucket);
            //now, iterate over every item in this bucket and insert it
            //to the input array
            for (var item : bucket)
                array[i++] = item;
        }
    }

    private List<List<Integer>> createBuckets(int[] array, int numberOfBuckets) {
        //each object in bucketList should be a linkedList of integers
        List<List<Integer>> buckets = new ArrayList<>(); //each bucket is linkedList of integer
        for (var i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        //iterate  over array and distribute items to different buckets
        for (var item : array)
            buckets.get(item / numberOfBuckets).add(item);

        return buckets;
    }
}
