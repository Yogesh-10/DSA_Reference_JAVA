package com.yogesh.queue;

import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            //remove one item from queue and push it to top of stack
            stack.push(queue.remove());
        while (!stack.isEmpty())
            //remove item from stack and push it to the queue
            queue.add(stack.pop());
    }
}
