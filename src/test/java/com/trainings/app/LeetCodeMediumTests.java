package com.trainings.app;
import com.trainings.tasks.LeetCodeMedium;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

}
