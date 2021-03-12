package com.yogesh.queue;

import java.util.Stack;

public class QueueWithTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    //O(1)
    public void enqueue(int item){
        stack1.push(item);
    }

    //O(n)
    public int dequeue(){
        //If both stack are empty(queue is empty)
        if (isEmpty())
            throw new IllegalStateException();

        //If stack 2 is empty push items from stack1 to stack2
        if (stack2.isEmpty())
            //If stack 1 is not empty, pop items from stack 1 and push to stack2
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        //If stack 2 is not empty pop from stack2, so that items in queue will be removed
        return stack2.pop();
    }

    public int peek(){
        //If both stack are empty(queue is empty)
        if (isEmpty())
            throw new IllegalStateException();

        //If stack 2 is empty push items from stack1 to stack2
        if (stack2.isEmpty())
            //If stack 1 is not empty, pop items from stack 1 and push to stack2
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        //If stack 2 is not empty pop from stack2, so that items in queue will be removed
        return stack2.peek();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
