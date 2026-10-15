package com.trainings.patterns;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoPointersPatterns {

    //344. Reverse String
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp = 0;

        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    //125. Valid Palindrome
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            System.out.printf("LEFT: %s \n", chars[left]);
            while (left < right && !Character.isLetterOrDigit(chars[left])) {
                System.out.printf("is LEFT alphanumeric: %s \n", Character.isLetterOrDigit(chars[left]));
                left ++;
            }
            System.out.printf("RIGHT: %s \n", chars[right]);
            while (left < right && !Character.isLetterOrDigit(chars[right])) {
                System.out.printf("is RIGHT alphanumeric: %s \n", Character.isLetterOrDigit(chars[right]));
                right --;
            }

            System.out.printf("COMPARE: left: %s, right: %s \n", chars[left], chars[right]);
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
            System.out.println("============");
        }
        return true;
    }

    //977. Squares of a Sorted Array
    public int[] sortedSquares(int[] nums) {
        for (int i =0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }

        Arrays.sort(nums);

        return nums;
    }

    //283. Move Zeroes
    public void moveZeroes(int[] nums) {
        int read;
        int write;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                read = i;
                write = i + 1;
                while(write < nums.length && nums[write] != 0) {
                    nums[read] = nums[write];
                    nums[write] = 0;
                    read++;
                    write++;
                }
            }
        }
    }

    //167. Two Sum II - Input Array Is Sorted
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int sum;

        while (left < numbers.length && left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target)
                return new int[] {left + 1, right + 1};
            else if (sum < target)
                left++;
            else right--;
        }
        return new int[2];
    }
}
