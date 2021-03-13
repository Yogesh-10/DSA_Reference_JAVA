package com.yogesh.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    public static int ALPHABET_SIZE = 26;
    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch){
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (var ch : word.toCharArray()) {
            //In each iteration we have to ask current node, do you have child
            //for current char, so first calculate index of child
            //var index = ch - 'a'; (with array approach)
            //If we dont have a node create it
            if (!current.hasChild(ch))
                current.addChild(ch);
            //point the current children index to current
            current = current.getChild(ch);
        }
        //Once we have visited every char in word, the current variable references
        //last node for the last character in this word
        current.isEndOfWord = true;
    }

    public boolean contains(String word){
        if (word == null)
            return false;

        var current = root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node root){
        //Pre-order : visit root first
        System.out.println(root.value);

        //Now visit each char one by one starting from left
        for (var child : root.getChildren())
            traverse(child);

        //Post-order traversal
        //for (var child : root.getChildren())
        //    traverse(child);

        //System.out.println(root.value);
    }

    public void remove(String word) {
        if (word == null)
            return;

        remove(root, word, 0);
    }

    //For delete operation : Post-order traversal
    private void remove(Node root, String word, int index) {
        //Base condition
        if (index == word.length()){
            root.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var child =root.getChild(ch);
        if (child == null)
            return;

        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(ch);
    }

    //Exercise :Auto-Completion
    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        var lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);

        return words;
    }

    private void findWords(Node root, String prefix, List<String> words){
        if (root == null)
            return;

        if (root.isEndOfWord)
            words.add(prefix);

        for (var child : root.getChildren())
            findWords(child, prefix + child.value, words);
    }

    private Node findLastNodeOf(String prefix){
        if (prefix == null)
            return null;

        var current = root;
        for (var ch : prefix.toCharArray()) {
            var child = current.getChild(ch);
            if (child == null)
                return null;
            current = child;
        }
        return current;
    }
}
