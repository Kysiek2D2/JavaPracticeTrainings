package com.trainings.tasks;

import java.util.Arrays;

class ArraySolutions {
    /**
     * Name: Remove duplicates from sorted Array
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
     * The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
     * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
     * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
     * The remaining elements of nums are not important as well as the size of nums.
     * Return k.
     * EXAMPLE:
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     */
    public int removeDuplicates(int[] nums) {
        //TIP: two-pointer approach used
        int currentNumber = nums[0];
        int result = 0;
        //Start from index 1vvvv
        for(int i = 1; i < nums.length; i++) {
            if(!(nums[i] == currentNumber)){
                currentNumber = nums[i];
                result++;
                nums[result] = currentNumber;
            }
        }
        return result + 1;
    }

    /**
     * Name: Best Time to Buy and Sell Stock II
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
     * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
     * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
     * However, you can buy it then immediately sell it on the same day.
     * Find and return the maximum profit you can achieve.
     * EXAMPLE:
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Total profit is 4 + 3 = 7.
     */
    public int maxProfit(int[] prices) {
        int total = 0;
        int currValue = 0;
        boolean isBought = false;
        //Loop until length - 1, so we won't fall in ArrayOutOfBoundsException
        for(int i = 0; i < prices.length - 1; i++){
            if(isBought == false && (prices[i+1] > prices[i])){
                currValue+=prices[i]; //buy
                isBought = true;
            } else if (isBought == true &&
                    (prices[i+1] < prices[i])){
                total += (prices[i]-currValue); //sell
                currValue = 0;
                isBought = false;
            }
        }
        if(isBought == true){
            total += (prices[prices.length-1]-currValue); //sell since it's last call
        }
        return total;
    }

    /**
     * Name: Contains Duplicate
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
     * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums); //sort it first using Arrays package
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    /**
     * Name: Single Number
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/549/
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     * Example:
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i+=2){
            if(!(nums[i] == nums[i+1])){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * Name: Intersection of Two Arrays
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
     * @Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
     * Example:
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] shorter = nums1.length < nums2.length ? nums1 : nums2;
        int[] longer = nums1.length < nums2.length ? nums2 : nums1;
        int index = 0;
        //traverse shorter Array
        for(int i = 0; i < shorter.length; i++){
            //traverse longer Array
            for(int j = index; j < longer.length; j++){
                //if match then move number to left of longer index and increase index
                //in next iteration ommit numbers that were 'put on side' (left)
                if(shorter[i] == longer[j]){
                    int temp = longer[index];
                    longer[index] = longer[j];
                    longer[j] = temp;
                    index++;
                    break;
                }
            }
        }
        //construct result Array
        int[] result = new int[index];
        for(int z = 0; z < index; z++){
            result[z] = longer[z];
        }
        return result;
    }

    /**
     * Name: Plus One
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
     * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
     * The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
     * Increment the large integer by one and return the resulting array of digits.
     * Example:
     * Input: digits = [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Incrementing by one gives 123 + 1 = 124.
     * Thus, the result should be [1,2,4].
     */
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;

        while(true){
            digits[index] += 1;
            if(digits[index] == 10){
                digits[index] = 0;
                index--;
            } else {
                break;
            }
            if(index < 0){
                break;
            }
        }

        if(digits[0] != 0){
            return digits;
        } else {
            //case when additional digit is required
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for(int j = 1; j < result.length; j++){
                result[j] = digits[j-1];
            }
            return result;
        }
    }

    /**
     * Name: Move Zeroes
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * Note that you must do this in-place without making a copy of the array.
     * Example:
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
        int lastZeroIndex = nums.length - 1;
        int i = 0;

        while(i < lastZeroIndex){
            if(nums[i] == 0){
                for(int j = i; j < lastZeroIndex; j++){
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
                lastZeroIndex--;
            }
            if(nums[i] != 0){
                i++;
            }
        }
    }

    /**
     * Name: Two Sum
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     * Example:
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[1];
    }

    public boolean isValidSudoku(char[][] board) {
        var a = Arrays.stream(new int[]{1,2,3}).distinct().toArray();
        return false;
    }
}

