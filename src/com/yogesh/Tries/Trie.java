package com.yogesh.Tries;

public class Trie {
    public static int ALPHABET_SIZE = 26;

    private class Node {
        private char value;
        private Node[] children = new Node[ALPHABET_SIZE];
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (var ch : word.toCharArray()) {
            //In each iteration we have to ask current node, do you have child
            //for current char, so first calculate index of child
            var index = ch - 'a';
            //If we dont have a node create it
            if (current.children[index] == null)
                current.children[index] = new Node(ch);
            //point the current children index to current
            current = current.children[index];
        }
        //Once we have visited every char in word, the current variable references
        //last node for the last character in this word
        current.isEndOfWord = true;
    }
}
