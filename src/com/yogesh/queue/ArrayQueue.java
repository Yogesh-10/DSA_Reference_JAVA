package com.yogesh.queue;

import java.util.Arrays;

//Implementing Queue using Arrays
public class ArrayQueue {
    private int[] items;
    private int rear;
    private int count;
    private int front;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item){
        if (count == items.length)
            throw new IllegalStateException();

        items[rear] = item;
        rear = (rear + 1) % items.length; //to make circular array and map it to empty position (to avoid ArrayOutOfBound exception and save space)
        count++;
    }

    public int dequeue(){
        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length; //for circular array (to avoid ArrayOutOfBound exception and save space)
        count--;
        return item;
    }

    @Override
    public String toString() {
        return  Arrays.toString(items);
    }
}
