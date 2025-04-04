package com.text.utils;

public class TextProcessor {
    public static String removeSpecialChars(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "");
    }
    
    public static int countWords(String text) {
        return text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
    }

    public static void main(String[] args) {
        String testString = "Hello, World! This is a test string.";
        System.out.println("Original: " + testString);
        System.out.println("Without special chars: " + removeSpecialChars(testString));
        System.out.println("Word count: " + countWords(testString));
    }
}
