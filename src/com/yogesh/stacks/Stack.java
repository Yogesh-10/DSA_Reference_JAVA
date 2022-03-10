package com.yogesh.stacks;

import java.util.Arrays;

public class Stack {
    private int[] items = new int[5];
    private int count;

    public void push(int item){
        if (count == items.length)
            throw new StackOverflowError();

        items[count++] = item;
    }

    public int pop(){
        checkUnderflow();
        //return items[--count];
        //or
        count--;
        return items[count];
    }

    public int peek(){
        //check for underflow condition 
        checkUnderflow();
        return items[count - 1];
    }
    
    public boolean isEmpty(){
        return count == 0;
    }
    
    public void checkUnderflow(){
        // throws IllegalStateException if there are no elements
        if (count == 0)
            throw new IllegalStateException();        
    }

    @Override
    public String toString() {
        //to store and print elements that is only pushed in stack, not the empty zeroes
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }
}
