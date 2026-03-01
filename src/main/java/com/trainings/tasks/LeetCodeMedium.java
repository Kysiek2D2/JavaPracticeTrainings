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
}
