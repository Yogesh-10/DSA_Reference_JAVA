package com.yogesh.hashtables;

//1.Find the first Non-repeating character in a string

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharacterFinder {
    public char findFirstNonRepeatingChar(String str){
        Map<Character, Integer> map = new HashMap<>();

        var chars = str.toCharArray();
        for (var ch : chars){
            //If we have character in hashtable, increment the
            //Count by 1, or insert to hashtable
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        //Iterate and find if char is repeated only once
        for (var ch : chars)
            if (map.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE; //Non existing character
    }

// 2.Find the first repeated character in a string
    public char findFirstRepeatedChar(String str){
        Set<Character> set = new HashSet<>();

        for (var ch : str.toCharArray()){
        //Ask the set if it contains this character, if yes
        // the character is repeated and we should return immediately
        // else, add it to set
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }
        //If none of character is repeated in string
        return Character.MIN_VALUE;
    }
}

