package com.trainings.app;

import com.trainings.patterns.TwoPointersPatterns;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatternTests {

    private final TwoPointersPatterns twoPointersPatterns = new TwoPointersPatterns();

    @Test
    void removeDuplicatesFromSortedArray_Test1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] expected = {1, 1, 2, 2, 3};

        int k = twoPointersPatterns.removeDuplicates(nums);

        assertEquals(5, k);
        assertArrayEquals(expected, Arrays.copyOf(nums, k));
    }

    @Test
    void removeDuplicatesFromSortedArray_Test2() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] expected = {0, 0, 1, 1, 2, 3, 3};

        int k = twoPointersPatterns.removeDuplicates(nums);

        assertEquals(7, k);
        assertArrayEquals(expected, Arrays.copyOf(nums, k));
    }

    @Test
    void removeDuplicatesFromSortedArray_Test3() {
        int[] nums = {1,1,1};
        int[] expected = {1,1};

        int k = twoPointersPatterns.removeDuplicates(nums);

        assertEquals(2, k);
        assertArrayEquals(expected, Arrays.copyOf(nums, k));
    }

    @Test
    void removeDuplicatesFromSortedArray_Test4() {
        int[] nums = {1,1,1,1};
        int[] expected = {1,1};

        int k = twoPointersPatterns.removeDuplicates(nums);

        assertEquals(2, k);
        assertArrayEquals(expected, Arrays.copyOf(nums, k));
    }
}
