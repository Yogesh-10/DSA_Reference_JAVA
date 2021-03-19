package com.yogesh.StringManipulation_Algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringUtils {
    //1.Count no.of vowels in string
    public static int countVowels(String str) {
        if (str == null)
            return 0;

        int count = 0;
        String vowels = "aeiou";
        for (var ch : str.toLowerCase().toCharArray())
            if (vowels.indexOf(ch) != -1)
                count++;
        return count;
    }

    //2.Reverse a string
    public static String reverse(String str) {
        if (str == null)
            return "";

        StringBuilder reversed = new StringBuilder();
        for (var i = str.length() - 1; i >= 0; i--)
            reversed.append(str.charAt(i));

        return reversed.toString();
    }

    //3.Reverse a word
    public static String reverseWords(String sentence) {
        if (sentence == null)
            return "";

        //split sentence in to individual words
        String[] words = sentence.trim().split( " ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);

        //or use below method.
//        StringBuilder reversed = new StringBuilder();
//        for (var i = words.length - 1; i >= 0; i--)
//            reversed.append(words[i] + " ");
//
//        return reversed.toString().trim();
    }

    //4. Rotations
    public static boolean areRotations(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;

        return (str1.length() == str2.length() &&
                (str1 + str2).contains(str2));
    }

    //5. Remove Duplicates from a string
    public static String removeDuplicates(String str) {
        if (str == null)
            return "";

        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (var ch : str.toCharArray()) {
            if (!seen.contains(ch)){
                seen.add(ch);
                output.append(ch);
            }
        }
        return output.toString();
    }

    //6. most repeated character in a string
    public static char getMaxOccurringChar(String str) {
        if (str == null || str.isEmpty())
            throw new IllegalArgumentException();

        final int ASCII_SIZE = 256;
        int[] frequencies = new int[ASCII_SIZE];
        for (var ch : str.toCharArray())
            frequencies[ch]++;

        int max = 0;
        char result = ' ';
        for (var i = 0; i < frequencies.length; i++)
            if (frequencies[i] > max) {
                max = frequencies[i];
                result = (char) i;
            }

//          Map<Character, Integer> frequencies = new HashMap<>();
//        for (var ch : str.toCharArray()) {
//            //If our hash table does'nt have this char, we should add
//            //with frequency of 1, otherwise we should increase this frequency
//            if (frequencies.containsKey(ch))
//                frequencies.replace(ch, frequencies.get(ch) + 1);
//            else
//                frequencies.put(ch, 1);
//    }
        return result;
    }

    //7.Sentence Capitalization
    public static String capitalize(String sentence) {
        if (sentence == null || sentence.trim().isEmpty())
            return "";

        String[] words = sentence.trim().replaceAll(" +"," ").split( " ");
        for (var i = 0; i < words.length; i++){
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        return String.join(" ", words);
    }

    //8. Anagrams - (have same character in different sequence)
     public static boolean areAnagrams(String first, String second) {
        if (first == null || second == null || first.length() != second.length())
            return false;

        var array1 = first.toLowerCase().toCharArray();
        Arrays.sort(array1);

        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
     }

     //9. Anagrams using different approach
     public static boolean areAnagrams2(String first, String second) {
        if (first == null || second == null)
            return false;

        final int ALPHABETS = 26;
        int[] frequencies = new int[ALPHABETS];

        first = first.toLowerCase();
        for (var i =0; i < first.length(); i++)
            frequencies[first.charAt(i) - 'a']++;

        second = second.toLowerCase();
        for (var i = 0; i < second.length(); i++){
            var index = second.charAt(i) - 'a';
            if (frequencies[index] == 0)
                return false;

            frequencies[index]--;
        }
        return true;
     }

     //10. Palindrome
    public static boolean isPalindrome(String word) {
        if (word == null)
            return false;

        int left = 0;
        int right = word.length() - 1;

        while (left < right)
            if (word.charAt(left++) != word.charAt(right--))
                return false;

        return true;

//        var input = new StringBuilder(word);
//        input.reverse();
//        return input.toString().equals(word);
    }
}
