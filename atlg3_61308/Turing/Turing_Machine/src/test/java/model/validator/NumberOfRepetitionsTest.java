package model.validator;

import model.Code;
import model.TuringException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfRepetitionsTest {
    @Test
    void testValidator20NoDoubleInCodeAndSecret() {
        Code codeSecret = new Code(134);
        NumberOfRepetitions validator = new NumberOfRepetitions( codeSecret);
        assertTrue(validator.verify(new Code(542)));
    }

    @Test
    void testValidator20DoubleInCodeAndSecret() {
        Code codeSecret = new Code(112);
        NumberOfRepetitions validator = new NumberOfRepetitions(codeSecret);
        assertTrue(validator.verify(new Code(211)));
    }

    @Test
    void testValidator20TripleInCodeAndSecret() {
        Code codeSecret = new Code(111);
        NumberOfRepetitions validator = new NumberOfRepetitions( codeSecret);
        assertTrue(validator.verify(new Code(111)));
    }

    @Test
    void testValidator20NoDoubleInCodeOneDoubleInSecret() {
        Code codeSecret = new Code(112);
        NumberOfRepetitions validator = new NumberOfRepetitions( codeSecret);
        assertFalse(validator.verify(new Code(542)));
    }

    @Test
    void testValidator20TripleInCodeOneDoubleInSecret() {
        Code codeSecret = new Code(112);
        NumberOfRepetitions validator = new NumberOfRepetitions( codeSecret);
        assertFalse(validator.verify(new Code(111)));
    }

    @Test
    void testValidator20TripleInCodeTwoDoubleInSecret() {
        Code codeSecret = new Code(112);
        NumberOfRepetitions validator = new NumberOfRepetitions( codeSecret);
        assertFalse(validator.verify(new Code(111)));
    }

    @Test
    void testValidator20NoDoubleInCodeTwoDoubleInSecret() {
        Code codeSecret = new Code(112);
        NumberOfRepetitions validator = new NumberOfRepetitions( codeSecret);
        assertFalse(validator.verify(new Code(213)));
    }

    /*
    @Test
    void testInvalidValidatorNumber() {
        Code codeSecret = new Code(123);
        assertThrows(TuringException.class, () ->new NumberOfRepetitions(codeSecret));
    }

     */

    /*
    @Test
    void testStringCategoryValidator20() {
        NumberOfRepetitions validator = new NumberOfRepetitions(20, new Code(123));
        assertEquals("no double | double digit | triple digit |", validator.stringCategory());
    }

     */

}