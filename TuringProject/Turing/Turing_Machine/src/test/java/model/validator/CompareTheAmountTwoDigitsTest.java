package model.validator;

import model.Code;
import model.TuringException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareTheAmountTwoDigitsTest {

    @Test
    void testCompareSumWithLowerValue() {
        Code code = new Code(153);
        CompareTheAmountTwoDigits CompareTheAmountTwoDigits = new CompareTheAmountTwoDigits(code);
        assertFalse(CompareTheAmountTwoDigits.verify(new Code(212)));
    }

    @Test
    void testCompareTheAmountTwoDigitsWithEqualValue() {
        Code code = new Code(345);
        CompareTheAmountTwoDigits CompareTheAmountTwoDigits = new CompareTheAmountTwoDigits(code);
        assertTrue(CompareTheAmountTwoDigits.verify(new Code(251)));
    }

    @Test
    void testCompareTheAmountTwoDigitsWithHigherValue() {
        Code code = new Code(432);
        CompareTheAmountTwoDigits CompareTheAmountTwoDigits = new CompareTheAmountTwoDigits(code);
        assertFalse(CompareTheAmountTwoDigits.verify(new Code(111)));
    }

    /*
    @Test
    void testInvalidValidatorNumber() {
        Code code = new Code(543);
        CompareTheAmountTwoDigits CompareTheAmountTwoDigits = new CompareTheAmountTwoDigits( code);
        assertThrows(TuringException.class, () -> CompareTheAmountTwoDigits.verify(new Code(321)));
    }

     */

    @Test
    void testCompareTheAmountTwoDigitsWithFixedValue() {
        Code code = new Code(155);
        CompareTheAmountTwoDigits CompareTheAmountTwoDigits = new CompareTheAmountTwoDigits( code);
        assertTrue(CompareTheAmountTwoDigits.verify(new Code(243)));
    }

    @Test
    void testCompareTheAmountTwoDigitsWithFixedValueHigher() {
        Code code = new Code(111);
        CompareTheAmountTwoDigits CompareTheAmountTwoDigits = new CompareTheAmountTwoDigits( code);
        assertFalse(CompareTheAmountTwoDigits.verify(new Code(453)));
    }

    @Test
    void testCompareTheAmountTwoDigitsWithInvalidCode() {
        Code code = new Code(222);
        CompareTheAmountTwoDigits CompareTheAmountTwoDigits = new CompareTheAmountTwoDigits( code);
        assertThrows(TuringException.class, () -> CompareTheAmountTwoDigits.verify(new Code(789)));
    }

    @Test
    void testCompareTheAmountTwoDigitsWithMinimumValues() {
        Code code = new Code(111);
        CompareTheAmountTwoDigits CompareTheAmountTwoDigits = new CompareTheAmountTwoDigits( code);
        assertTrue( CompareTheAmountTwoDigits.verify(new Code(111)));
    }

    @Test
    void testCompareTheAmountTwoDigitsWithMaximumValues() {
        Code code = new Code(555);
        CompareTheAmountTwoDigits CompareTheAmountTwoDigits = new CompareTheAmountTwoDigits( code);
        assertTrue( CompareTheAmountTwoDigits.verify(new Code(555)));
    }

    @Test
    void testCompareTheAmountTwoDigitsWithRandomValues() {
        Code code = new Code(252);
        CompareTheAmountTwoDigits CompareTheAmountTwoDigits = new CompareTheAmountTwoDigits( code);
        assertTrue(CompareTheAmountTwoDigits.verify(new Code(433)));
    }
}