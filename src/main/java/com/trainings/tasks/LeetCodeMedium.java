package com.trainings.tasks;

import java.util.*;

public class LeetCodeMedium {

    //15. 3Sum
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                int secondNum = nums[j];
                for(int z = j + 1; z < nums.length; z++) {
                    int thirdNum = nums[z];

                    if(firstNum + secondNum + thirdNum == 0) {
                        List<Integer> tripletListTemp = new ArrayList<>();
                        tripletListTemp.add(firstNum);
                        tripletListTemp.add(secondNum);
                        tripletListTemp.add(thirdNum);
                        tripletListTemp.sort((a,b) -> a - b);

                        boolean isDuplicate = false;
                        for(List<Integer> innerList : result) {
                            innerList.sort(Integer::compare);
                            if(innerList.get(0) == tripletListTemp.get(0) &&
                                    innerList.get(1) == tripletListTemp.get(1) &&
                                    innerList.get(2) == tripletListTemp.get(2)) {
                                isDuplicate = true;
                            }
                        }

                        if(!isDuplicate) {
                            result.add(tripletListTemp);
                        }
                    }
                }
            }
        }
        return result;
    }

    //2. Add Two Numbers
    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new ListNode();
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int iteration = 0;
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        ListNode firstResultNode = new ListNode();
        ListNode currentResultNode = firstResultNode;
        int extraNumberFromPreviousSum = 0;
        while (currentL1 != null || currentL2 != null) {
            iteration++;
            int val1 = 0;
            int val2 = 0;
            if(currentL1 != null) {
                val1 = currentL1.val;
                currentL1 = currentL1.next;
            }
            if(currentL2 != null) {
                val2 = currentL2.val;
                currentL2 = currentL2.next;
            }

            currentResultNode.val = val1 + val2 + extraNumberFromPreviousSum;
            extraNumberFromPreviousSum = 0;
            if (currentResultNode.val >= 10) {
                extraNumberFromPreviousSum = 1;
                currentResultNode.val = currentResultNode.val - 10;
            }

            debugStatement: {
                System.out.println("iteration: " + iteration);
                System.out.println("L1.val: " + val1);
                System.out.println("L2.val: " + val2);
                System.out.println("extraNumberFromPreviousSum: " + extraNumberFromPreviousSum);
            }
            if (currentL1 != null || currentL2 != null) {
                currentResultNode.next = new ListNode();
                currentResultNode = currentResultNode.next;
            }
        }

        if (extraNumberFromPreviousSum > 0) {
            currentResultNode.next = new ListNode(extraNumberFromPreviousSum);
        }
        return firstResultNode;
    }

    //3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        if (s.length() == 1 || s.isEmpty()) {
            return s.length();
        }

        int firstCharIndex = 0;
        int nextCharIndex = 0;
        int longestFoundStringLength = 0;

        while (nextCharIndex < s.length() - 1) {
            firstCharIndex = findFirstDuplicateCharIndex(firstCharIndex, nextCharIndex, s);
            nextCharIndex++;
            if (nextCharIndex - firstCharIndex + 1 > longestFoundStringLength) {
                longestFoundStringLength = nextCharIndex - firstCharIndex + 1;
            }
        }

        return longestFoundStringLength;
    }

    private int findFirstDuplicateCharIndex(int firstCharIndex, int nextCharIndex, String s) {
        String subString = s.substring(firstCharIndex, nextCharIndex + 1);

        char nextChar = s.charAt(nextCharIndex + 1);

        System.out.println("subString: " + subString
                + ", firstCharIndex: " + firstCharIndex
                + ", nextCharIndex: " + nextCharIndex
                + ", nextChar: " + nextChar);

        for (int i = 0; i < subString.length(); i++) {
            if (nextChar == subString.charAt(i)) {
                return firstCharIndex + i + 1;
            }
        }
        return firstCharIndex;
    }

    //5. Longest Palindromic Substring
    public String longestPalindrome(String s) {
        int longestPalindromeLength = s.length() - 1;
        while (longestPalindromeLength > 0) {
            System.out.println("longestPalindromeLength: " + longestPalindromeLength);
            for (int y = 0; y < s.length() - longestPalindromeLength; y++) {
                String subString = s.substring(y, y + longestPalindromeLength);
                System.out.println("subString: " + subString);
                if (isPalindrome(subString)) {
                    return subString;
                }
            }
            longestPalindromeLength--;
        }
        return "";
    }

    private boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        if (s.length() == 1) {
            return true;
        }

        char[] charArray = s.toCharArray();
        int i = 0;
        int j = charArray.length - 1;
        while (true) {
            if (charArray[i]  != charArray[j]) {
                return false;
            }
            i++;
            j--;
            if (i > charArray.length / 2) {
                return true;
            }
        }
    }

    public String longestPalindromeBetterSolution(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0, maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindromes
            int len1 = expand(s, i, i);
            // Even length palindromes
            int len2 = expand(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    //6. Zigzag Conversion
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        char[] charArray = s.toCharArray();

        StringBuilder result = new StringBuilder();
        //prepare zigzag
        int zigzagPointerPosition = 0;
        int zigzagRowLastChar = 0;
        int zigzagPointerColumnCurrent = 0;
        int zigzagPointerRowCurrent = 0;
        boolean isSlayMovementActive = false;

        do {
            if (zigzagPointerPosition >= charArray.length) {
                zigzagRowLastChar++;
                zigzagPointerRowCurrent = zigzagRowLastChar;
                zigzagPointerPosition = zigzagRowLastChar;
                zigzagPointerColumnCurrent = 0;
                isSlayMovementActive = false;
                continue;
            }

            if (zigzagRowLastChar == zigzagPointerRowCurrent) {
                System.out.println("Append: " + charArray[zigzagPointerPosition]);
                result.append(charArray[zigzagPointerPosition]);
            }

            zigzagPointerPosition++;

            if (isSlayMovementActive &&  (zigzagPointerRowCurrent - 1 < 0)) {
                isSlayMovementActive = false;
            }

            if (!isSlayMovementActive && (zigzagPointerRowCurrent + 1 < numRows)) {
                zigzagPointerRowCurrent++;
            } else {
                zigzagPointerRowCurrent--;
                zigzagPointerColumnCurrent++;
                isSlayMovementActive = true;
            }

        } while (result.length() != charArray.length);

        return result.toString();
    }

    //8. String to Integer (atoi)
    public int myAtoi(String s) {

        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        char[] charArr = s.toCharArray();

        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();

        //check sign and leading zero
        if (charArr[index] == '-') {
            stringBuilder.append('-');
            index++;
        } else if (charArr[index] == '+') {
            index++;
        }

        boolean shouldCheckForLeadingZeroFlag = true;

        while (index < charArr.length && Character.isDigit(charArr[index])) {
            if (shouldCheckForLeadingZeroFlag && charArr[index] == '0') {
                index++;
                continue;
            } else {
                shouldCheckForLeadingZeroFlag = false;
            }
            stringBuilder.append(charArr[index]);
            index++;
        }

        String stringResult = stringBuilder.toString();
        if (stringResult.isEmpty() ||
            stringResult.equals("-") ||
            stringResult.equals("+")) {
            return 0;
        }

        if (stringResult.startsWith("-") &&
                stringResult.length() > String.valueOf(Integer.MIN_VALUE).length()) {
            return Integer.MIN_VALUE;
        } else if (!stringResult.startsWith("-") &&
                stringResult.length() > String.valueOf(Integer.MAX_VALUE).length()) {
            return Integer.MAX_VALUE;
        }

        long longResult = Long.parseLong(stringResult);
        if (longResult > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (longResult < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return Integer.parseInt(stringResult);
    }

    //11. Container With Most Water
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int currentLeftIndex = 0;
        int currentRightIndex = height.length - 1;
        int highestContainerSize = 0;
        int currentContainerSize;

        while (currentLeftIndex < currentRightIndex) {
            currentContainerSize = getCurrentContainersSize(currentLeftIndex, currentRightIndex, height);
            if (currentContainerSize > highestContainerSize) {
                highestContainerSize = currentContainerSize;
            }

            if (height[currentLeftIndex] <= height[currentRightIndex]) {
                currentLeftIndex++;
            } else {
                currentRightIndex--;
            }
        }

        return highestContainerSize;
    }

    private int getCurrentContainersSize(int currentLeftIndex, int currentRightIndex, int[] height) {
        int currentContainerHeight = Integer.min(height[currentLeftIndex], height[currentRightIndex]);
        int currentContainerWidth = currentRightIndex - currentLeftIndex;

        return currentContainerHeight * currentContainerWidth;
    }

    //12. Integer to Roman
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        Map<Integer, String> romanSymbolsMap = new LinkedHashMap<>();
        romanSymbolsMap.put(1000, "M");
        romanSymbolsMap.put(500, "D");
        romanSymbolsMap.put(100, "C");
        romanSymbolsMap.put(50, "L");
        romanSymbolsMap.put(10, "X");
        romanSymbolsMap.put(5, "V");
        romanSymbolsMap.put(1, "I");

        Map<Integer, String> substractiveFormsMap = new HashMap<>();
        substractiveFormsMap.put(4, "IV");
        substractiveFormsMap.put(9, "IX");
        substractiveFormsMap.put(40, "XL");
        substractiveFormsMap.put(90, "XC");
        substractiveFormsMap.put(400, "CD");
        substractiveFormsMap.put(900, "CM");

        List<Integer> decimalPlaceValuesList = createDecimalPlaceValuesList(num);

        for (int currentNumber : decimalPlaceValuesList) {
            result.append(convertIntToRoman(currentNumber, romanSymbolsMap, substractiveFormsMap));
        }
        System.out.println("FINAL RESULT: " + result);
        return result.toString();
    }

    private List<Integer> createDecimalPlaceValuesList(int num) {
        List<Integer> decimalPlaceValuesList = new ArrayList<>();
        int currentSum = 0;
        int currentRest = num;
        int currentPowerOf10 = (int) Math.pow(10, String.valueOf(num).length() - 1);
        while (currentSum < num) {
            int tempDecimal = (currentRest / currentPowerOf10) * currentPowerOf10;
            decimalPlaceValuesList.add(tempDecimal);
            currentSum += tempDecimal;
            currentRest -= tempDecimal;
            currentPowerOf10 = currentPowerOf10 / 10;
            System.out.println(tempDecimal);
        }
        return decimalPlaceValuesList;
    }

    private String convertIntToRoman(int currentNumber, Map<Integer, String> romanSymbolsMap, Map<Integer, String> substractiveFormsMap) {
        
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : romanSymbolsMap.entrySet()) {
            if (!String.valueOf(currentNumber).startsWith("4") && !String.valueOf(currentNumber).startsWith("9")) {
                if (entry.getKey() <= currentNumber) {
                    result.append(entry.getValue());
                    currentNumber -= entry.getKey();
                    break;
                }
            } else {
                result.append(getSubtractiveForm(currentNumber, substractiveFormsMap));
                currentNumber = 0;
                break;
            }
        }

        if (currentNumber != 0) {
            result.append(convertIntToRoman(currentNumber, romanSymbolsMap, substractiveFormsMap));
        }

        System.out.println("Return from convertIntToRoman: " + result);
        return result.toString();
    }

    private String getSubtractiveForm(int currentNumber, Map<Integer, String> substractiveFormsMap) {
        String foundRomanNumber = substractiveFormsMap.get(currentNumber);

        if (foundRomanNumber == null) {
            throw new NoSuchElementException();
        }

        return foundRomanNumber;
    }

    //
}
