package com.october;

import java.util.Arrays;

/**
 * Springboot Challenge:
 * Create an HTTP GET REQUEST that takes two strings as parameters and returns a body that contains if those strings are
 * anagrams. Use the function below and organize it inside a springboot application.
 * <p>
 * <p>
 * Create a function isAnagram(a, b) that checks if two given strings a and b are case-insensitive anagrams of each
 * other. Return true if they are anagrams, otherwise false.
 * <p>
 * Examples:
 * <p>
 * isAnagram("Anagram", "margana") returns true
 * isAnagram("Anagramm", " marganaa") returns false
 * isAnagram("Hello", "hello") returns true
 * isAnagram("Listen", "silent") returns true
 * isAnagram("triangle","integral") returns true
 * isAnagram("binary", "brainy") returns false
 * <p>
 * Tips:
 * <p>
 * The English alphabet consists of 26 characters. These characters are the letters from 'a' to 'z'.
 */
public class Solution {


    public static boolean isAnagram(String a, String b) {

        char[] aChar = a.toLowerCase().toCharArray();
        char[] bChar = b.toLowerCase().toCharArray();

        Arrays.sort(aChar);
        Arrays.sort(bChar);

        return Arrays.equals(aChar, bChar);
    }


    public static void main(String[] args) {

        String a1 = "Anagram";
        String b1 = "margana";

        if (!isAnagram(a1, b1)) {
            System.out.println("Test 1 failed");
            return;
        }

        String a2 = "Anagramm";
        String b2 = "marganaa";

        if (isAnagram(a2, b2)) {
            System.out.println("Test 2 failed");
            return;
        }

        String a3 = "Hello";
        String b3 = "hello";

        if (!isAnagram(a3, b3)) {
            System.out.println("Test 3 failed");
            return;
        }

        System.out.println("All tests passed!");
    }

}