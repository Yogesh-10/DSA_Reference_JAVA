package com.yogesh.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
    public class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node first; //head
    private Node last;  //tail
    private int size;

    public void addLast(int item){
        var newNode = new Node(item);

        //if linked list is empty, point first and last to new node
        if (isEmpty())
            first = last = newNode;
        //otherwise, append node to end of linked list
        else{
            //newNode will be added after tail such that tail's next will point to newNode
            last.next = newNode;
            //newNode will become new tail of the list
            last = newNode;
        }
        size++;
    }

    public void addFirst(int item){
        var newNode = new Node(item);

        if(isEmpty())
            first = last = newNode;
        else{
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    private boolean isEmpty(){
        return first == null;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next; //set current to next node and check for item
            index++;
        }
        //if unable to find item,
        return -1;
    }

    public boolean contains(int item){
        //if contains return item, else -1
        return indexOf(item) != -1;
    }

    public void removeFirst(){
        if (isEmpty())
            throw new NoSuchElementException();

        //If list contains only one item
        if (first == last)
            first = last = null;
        else {
            var second = first.next; //pointing first to second node since first is removed
            first.next = null; //set null to first node after removing
            first = second;
        }
        size--;
    }

    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();

        //if we have single node
        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    private Node getPrevious(Node last){
        var current = first;
        while (current != null){
            if (current.next == last) return current;
            current = current.next;
        }
        return null;
    }

    public int size(){
        return size;
    }

    public void print() {
        //Node current will point to head
        Node current = first;

        if(first == null) {
            System.out.println("List is empty");
            return;
        }

        while(current != null) {
            //Prints each node by incrementing pointer
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    //convert LinkedList to array
    public int[] toArray(){
        int [] array = new int[size];
        var current = first;
        var index = 0;
        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse(){
        //[10, 20, 30]
        // p   c   n   -> prev, curr, next
        if(isEmpty()) return;

        var previous = first;
        var current = first.next;
        while (current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        last.next = null;
        first = previous;
    }

//    Exercise - get kth integer from end
    public int getKthFromTheEnd(int k){
        if (isEmpty())
            throw new IllegalStateException();
        var a = first; //first pointer
        var b = first; //second pointer
        for(int i = 0; i < k-1; i++) {
            b = b.next; //moving second pointer forward
            if (b == null)
                throw new IllegalArgumentException();
        }
        //both pointers is in correct position,
        // now move both pointers until reaching end pf list.
        while (b != last){
            a = a.next;
            b = b.next;
        }
        return a.value; //return the kthInteger from end.
    }

}
