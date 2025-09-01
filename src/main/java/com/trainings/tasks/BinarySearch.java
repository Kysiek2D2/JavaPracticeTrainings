package com.trainings.tasks;

public class BinarySearch {

    /**
     *
     * @param arr - array need to be sorted first
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        //ArraySolutions.java.sort(arr); //array need to be sorted before first use
        if (left > right) {
            return -1;
        }

        int midIndex = left + (right - left) / 2;

        if (arr[midIndex] == target) {
            return midIndex;
        } else if (arr[midIndex] > target) {
            return binarySearch(arr, target, left, midIndex - 1);
        } else {
            return binarySearch(arr, target, midIndex + 1, right);
        }
    }
}
