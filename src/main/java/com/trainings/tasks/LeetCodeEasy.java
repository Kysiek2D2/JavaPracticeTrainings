package com.trainings.tasks;

import java.util.*;

public class LeetCodeEasy {

    //1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        if(nums.length < 2) {
            return new int[]{0,0};
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }

    //9. Palindrome Number
    public boolean isPalindrome(int x) {
        char[] charArray = String.valueOf(x).toCharArray();
        int chrArrLen = charArray.length;
        for(int i = 0; i < chrArrLen / 2; i++){
            if(charArray[i] != charArray[chrArrLen - 1 - i]){
                return false;
            }
        }
        return true;
    }

    //13. Roman to Integer
    public int romanToInt(String s) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int index = 0;

        for(int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            if(i + 1 >= s.length()) {
                result += curr;
            } else {
                int next = map.get(s.charAt(i+1));
                if(next > curr){
                    result += (next - curr);
                    i++;
                } else {
                    result += curr;
                }
            }
        }
        return result;
    }

    //14. Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int index = 0;

        if(strs == null || strs.length == 0){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }

        while(index <= strs[0].length()){
            for(int i = 0; i + 1 < strs.length; i++) {
                if(index >= strs[i].length() ||
                        index >= strs[i+1].length() ||
                        strs[i].charAt(index) != strs[i+1].charAt(index)){
                    return strs[0].substring(0, index);
                }
            }
            result = strs[0].substring(0, index);
            index++;
        }
        return result;
    }

}
