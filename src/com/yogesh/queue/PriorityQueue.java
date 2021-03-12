package com.yogesh.queue;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items =new int[5];
    private int count;

    public void add(int item){
        if (count == items.length)
            throw new IllegalStateException();
        //Iterate from end to beginning
        int i;
        for (i = count - 1; i >= 0; i--){
            //If item in list is greater than item we want to insert,
            // then, copy value of current cell to right cell(shifting to right)
            if (items[i] > item)
                items[i + 1] = items[i];
            //If current item in list is not greater than value we want to
            // insert, that means we found the position to insert the new item to list
            else
                break;
        }
        //position for inserting new item
        items[i + 1] = item;
        count++;
    }

    public int remove(){
        if (isEmpty())
            throw new IllegalStateException();
        return items[--count];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
