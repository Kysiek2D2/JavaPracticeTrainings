package com.trainings.tasks;

/*
Implement a method that counts the number of words - example "carrot  toy toy bean bean " result is ->>
bean 2
toy 2
carrot 1

The result should be printed in descending order of occurrences; if there is a tie in the number of occurrences, alphabetical order should be preserved.
Protect the method against null inputs.
*/

import java.util.*;
import java.util.stream.Collectors;

public class WordCounter {

    public Map<String, Integer> countWords(String input) {
        Map<String, Integer> result = new LinkedHashMap<>();
        if (input == null) {
            System.out.println("Null input");
            return Map.of();
        }

        Map<String, Integer> wordsCount = new HashMap<>();

        String[] words = input.split(" ");

        for (String word : words) {
            String wordTrimmed = word.trim().toLowerCase();
            if (wordTrimmed.equals("")){
                continue;
            }

             wordsCount.merge(wordTrimmed, 1, Integer::sum);
        }

        var sortedList = wordsCount.entrySet().stream().sorted((a,b) -> {
            int diff = b.getValue() - a.getValue();
            if (diff != 0) {
                return diff;
            } else
                return a.getKey().compareTo(b.getKey());
        }).collect(Collectors.toList());

        for(var wordCounted : sortedList) {
            result.put(wordCounted.getKey(), wordCounted.getValue());
        }

        System.out.println(result);

        return result;
    }

    public static void main(String[] args) {
        new WordCounter().countWords("test  test alpha alpha  " +
                "sii sii     sii test test alpha");
        new WordCounter().countWords(null);
    }
}
