package com.trainings.tasks;

public class ReverseString {

    public static String reverseWord(String originalWord) {
        char[] wordArr = originalWord.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = wordArr.length - 1; i >= 0; i--) {
            result.append(wordArr[i]);
        }
        return result.toString();
    }
}
