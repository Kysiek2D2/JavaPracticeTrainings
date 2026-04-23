package com.trainings.app;
import com.trainings.tasks.LeetCodeMedium;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LeetCodeMediumTests {

    LeetCodeMedium leetCodeMedium = new LeetCodeMedium();

    //6. Zigzag Conversion
    @Test
    void zigzagConversion1() {
        String result = leetCodeMedium.convert("PAYPALISHIRING", 3);
        assert(result.equals("PAHNAPLSIIGYIR"));
    }

    @Test
    void zigzagConversion2() {
        String result = leetCodeMedium.convert("PAYPALISHIRING", 4);
        assert(result.equals("PINALSIGYAHRPI"));
    }

    //8. String to Integer (atoi)
    @Test
    void myAtoi1() {
        String testString = " -42";
        int anticipatedResult = 42;
        int result = leetCodeMedium.myAtoi(testString);
        assert(result == anticipatedResult);
    }

    @Test
    void myAtoi2() {
        String testString = " -042";
        int anticipatedResult = 42;
        int result = leetCodeMedium.myAtoi(testString);
        assert(result == anticipatedResult);
    }

    @Test
    void myAtoi3() {
        String testString = "1337c0d3";
        int anticipatedResult = 1337;
        int result = leetCodeMedium.myAtoi(testString);
        assert(result == anticipatedResult);
    }

    @Test
    void myAtoi4() {
        String testString = "0-1";
        int anticipatedResult = 0;
        int result = leetCodeMedium.myAtoi(testString);
        assert(result == anticipatedResult);
    }

    //11. Container With Most Water
    @Test
    void maxArea1() {
        int[] input = new int[]{1,8,6,2,5,4,8,3,7};
        int anticipatedResult = 49;
        int result = leetCodeMedium.maxArea(input);
        System.out.println("result: " + result);
        assert(result == anticipatedResult);
    }

    @Test
    void maxArea2() {
        int[] input = new int[]{1,2,4,3};
        int anticipatedResult = 4;
        int result = leetCodeMedium.maxArea(input);
        System.out.println("result: " + result);
        assert(result == anticipatedResult);
    }

    @Test
    void maxArea3() {
        int[] input = new int[]{1,2,1};
        int anticipatedResult = 2;
        int result = leetCodeMedium.maxArea(input);
        System.out.println("result: " + result);
        assert(result == anticipatedResult);
    }

    //12. Integer to Roman
    @Test
    void integerToRoman1() {
        int input = 3749;
        String anticipatedResult = "MMMDCCXLIX";
        String result = leetCodeMedium.intToRoman(input);
        assert(anticipatedResult.equals(result));
    }

    @Test
    void integerToRoman2() {
        int input = 1994;
        String anticipatedResult = "MCMXCIV";
        String result = leetCodeMedium.intToRoman(input);
        assert(anticipatedResult.equals(result));
    }

    //15. 3Sum
    @Test
    void threeSum_basicCase() {
        int[] input = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> expected = List.of(
                List.of(-1, -1, 2),
                List.of(-1, 0, 1)
        );

        List<List<Integer>> result = leetCodeMedium.threeSum(input);

        assertEquals(normalize(expected), normalize(result));
    }

    private Set<List<Integer>> normalize(List<List<Integer>> input) {
        return input.stream()
                .map(list -> list.stream()
                        .sorted()
                        .collect(Collectors.toList()))
                .collect(Collectors.toSet());
    }

    //16. 3Sum Closest
    @Test
    public void threeSumClosest_test_1() {

        int[] inputArray = new int[]{-1,2,1,-4};
        int inputTarget = 1;
        int expectedResult = 2;
        int result = leetCodeMedium.threeSumClosest(inputArray, inputTarget);

        assertEquals(expectedResult, result);
    }

    @Test
    public void threeSumClosest_test_2() {

        int[] inputArray = new int[]{4,0,5,-5,3,3,0,-4,-5};
        int inputTarget = -2;
        int expectedResult = -2;
        int result = leetCodeMedium.threeSumClosest(inputArray, inputTarget);

        assertEquals(expectedResult, result);
    }
}
