package model.validator;

import model.Code;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParityOfTheSumNumbersTest {
    @Test
    void testValidator18ParityOfTheSumNumbersInCodeAndSecret() {
        Code codeSecret = new Code(242);
        ParityOfTheSumNumbers validator = new ParityOfTheSumNumbers( codeSecret);
        assertTrue(validator.verify(new Code(235)));
    }

    @Test
    void testValidator18OddSumInCodeAndSecret() {
        Code codeSecret = new Code(135);
        ParityOfTheSumNumbers validator = new ParityOfTheSumNumbers( codeSecret);
        assertTrue(validator.verify(new Code(144)));
    }

    @Test
    void testValidator18ParityOfTheSumNumbersInCodeOddSumInSecret() {
        Code codeSecret = new Code(135);
        ParityOfTheSumNumbers validator = new ParityOfTheSumNumbers( codeSecret);
        assertFalse(validator.verify(new Code(222)));
    }

    @Test
    void testValidator18OddSumInCodeParityOfTheSumNumbersInSecret() {
        Code codeSecret = new Code(141);
        ParityOfTheSumNumbers validator = new ParityOfTheSumNumbers( codeSecret);
        assertFalse(validator.verify(new Code(245)));
    }

    /*
    @Test
    void testInvalidValidatorNumber() {
        Code codeSecret = new Code(123);
        ParityOfTheSumNumbers validator = new ParityOfTheSumNumbers( codeSecret);
        assertThrows(IllegalArgumentException.class, () -> validator.verify(new Code(321)));
    }
    */


    /*
    @Test
    void testStringCategoryValidator18() {
        ParityOfTheSumNumbers validator = new ParityOfTheSumNumbers( new Code(123));
        assertEquals("the sum of digits are even | the sum of digits are not even", validator.stringCategory());
    }

     */



    @Test
    void testValidator18OddSumInCodeOddSumInSecret() {
        Code codeSecret = new Code(135);
        ParityOfTheSumNumbers validator = new ParityOfTheSumNumbers( codeSecret);
        assertTrue(validator.verify(new Code(111)));
    }

    @Test
    void testValidator18ParityOfTheSumNumbersInCodeParityOfTheSumNumbersInSecret() {
        Code codeSecret = new Code(244);
        ParityOfTheSumNumbers validator = new ParityOfTheSumNumbers(
                codeSecret);
        assertTrue(validator.verify(new Code(112)));
    }

}