package com.trainings.patterns;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapHashSetPatterns {

    //EASY: 1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); //value -> index

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            Integer mapDifferenceOccurrenceIndex = seen.get(difference);
            if (mapDifferenceOccurrenceIndex != null) {
                return new int[]{i, mapDifferenceOccurrenceIndex};
            } else {
                seen.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    //EASY: 217. Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    //MEDIUM: 49. Group Anagrams
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> seen = new HashMap<>(); //key = ordered string by chars -> value = List of original Strings
        for (String str : strs) {
            char[] strCharArray = str.toCharArray();
            Arrays.sort(strCharArray);
            String keyCandidate = Arrays.toString(strCharArray);
            seen.computeIfAbsent(keyCandidate, k -> new ArrayList<>()).add(str);
        }

        for(Map.Entry<String, List<String>> entry : seen.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    //EASY: 242. Valid Anagram
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> leftMap = new HashMap<>(); //key = letter -> value = occurence
        char[] leftToArray = s.toCharArray();

        for (Character c : leftToArray) {
            leftMap.put(c, leftMap.getOrDefault(c, 0) + 1);
        }

        char[] rightToArray = t.toCharArray();
        for (Character c : rightToArray) {
            int occurrences = leftMap.computeIfAbsent(c, k -> 0);
            if (occurrences == 0) {
                return false;
            }
            leftMap.put(c, occurrences - 1);
        }
        return true;
    }

    //MEDIUM: 347. Top K Frequent Elements
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> occurenceMap = new HashMap<>();

        for (int num : nums) {
            occurenceMap.put(num, occurenceMap.getOrDefault(num, 0) + 1);
        }

        List<NumberAndOccurenceRecord> records = new ArrayList<>();

        for (Map.Entry<Integer, Integer> e : occurenceMap.entrySet()) {
            records.add(new NumberAndOccurenceRecord(e.getKey(), e.getValue()));
        }

        records.sort((a, b) -> b.occurrence - a.occurrence); //reverse order

        int index = 0;
        for (NumberAndOccurenceRecord r : records) {
            result[index] = r.number;
            index++;
            if (index >= k)
                break;
        }

        return result;
    }

    record NumberAndOccurenceRecord(int number, int occurrence){}

    //MEDIUM: 36. Valid Sudoku
    public boolean isValidSudoku(char[][] board) {

        //vertically
        for (int i = 0; i < board.length; i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                //System.out.printf("VERTICAL i: %s, HORIZONTAL j: %s \n", i, j);
                if ('.' == board[i][j])
                    continue;
                if (!seen.add(board[i][j])) {
                    return false;
                }
            }
        }

        //horizontally
        for (int i = 0; i < board.length; i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                //System.out.printf("VERTICAL j: %s, HORIZONTAL i: %s \n", j, i);
                if (i >= board[j].length ||
                        board[j][i] == '.')
                    continue;
                if (!seen.add(board[j][i])) {
                    return false;
                }
            }
        }

        //sub-squares
        for (int k = 0; k < 3; k++){
            for (int z = 0; z < 3; z++) {
                System.out.println("======");
                System.out.println("Set restart");
                Set<Character> seen = new HashSet<>();
                for (int i = k * 3; i <  (k * 3) + 3; i++) {
                    for (int j = z * 3; j < (z * 3) + 3; j++) {
                        System.out.printf("VERTICAL i: %s, HORIZONTAL j: %s (value = %s) \n", i, j, board[i][j]);
                        if (board[i][j] == '.')
                            continue;
                        if (!seen.add(board[i][j])) {
                            System.out.println("added value to set: " + board[i][j]);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
