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
}
