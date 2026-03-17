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
}
