package com.yogesh.hashtables;

import java.util.LinkedList;

public class HashTable {
    private class Entry{
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value){
        var index = hash(key);
        //if null create new instance of LinkedList
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        //To avoid duplicate key,-> Iterate through the list, If
        // we find entry with same key, then update or overwrite the value
        var bucket = entries[index];
        for (var entry : bucket){
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        //otherwise, add new entry at end of linked list
        var entry = new Entry(key, value);
        entries[index].addLast(entry);
    }

    public String get(int key) {
        var index = hash(key);
        var bucket = entries[index];

        if (bucket != null) {
            //iterate over this bucket, and find the entry with the
            // same key, then return the value, otherwise we dont have
            // entry in hashtable
            for (var entry : bucket)
                if (entry.key == key)
                    return entry.value;
        }
        //if no entry found, return null
        return null;
    }

    public void remove(int key){
        var index = hash(key);
        var bucket = entries[index];
        if (bucket == null)
            throw new IllegalStateException();

        //if not null, iterate over linkedList and compare its key
        //with the key, passed in remove method and if found remove the key
        for (var entry : bucket){
            if (entry.key == key){
                bucket.remove(entry);
                return;
            }
        }
        //if we could not find a key in bucket
        throw new IllegalStateException();
    }

    //HashTable use a hashFunction to map a key to index value
    //HashFunction will tell where the object should be stored in
    // memory, and our HashTable will store the object at that location
    //Find the index stored in memory
    //Below is simple algorithm for hashFunction method, that returns the index
    private int hash(int key){
        return key % entries.length;
    }

}

