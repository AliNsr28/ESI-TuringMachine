package model.validator;

import model.Code;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderOfNumbersTest {
    @Test
    void testValidator22AscendingOrder() {
        Code codeSecret = new Code(123);
        OrderOfNumbers validator = new OrderOfNumbers( codeSecret);
        assertTrue(validator.verify(new Code(345)));
    }

    @Test
    void testValidator22DescendingOrder() {
        Code codeSecret = new Code(543);
        OrderOfNumbers validator = new OrderOfNumbers( codeSecret);
        assertTrue(validator.verify(new Code(321)));
    }

    @Test
    void testValidator22NoSpecificOrder() {
        Code codeSecret = new Code(312);
        OrderOfNumbers validator = new OrderOfNumbers( codeSecret);
        assertTrue(validator.verify(new Code(213)));
    }

    @Test
    void testValidator22InvalidOrder() {
        Code codeSecret = new Code(123);
        OrderOfNumbers validator = new OrderOfNumbers( codeSecret);
        assertFalse(validator.verify(new Code(321)));
    }

   /*
    @Test
    void testStringCategoryValidator22() {
        OrderOfNumbers validator = new OrderOfNumbers(22, new Code(123));
        assertNull(validator.stringCategory());
    }

    */

    @Test
    void testValidatorWithIdenticalCodes() {
        Code codeSecret = new Code(234);
        OrderOfNumbers validator = new OrderOfNumbers( codeSecret);
        assertTrue(validator.verify(new Code(234)));
    }
    @Test
    void testValidatorWithDifferentCodes() {
        Code codeSecret = new Code(235);
        OrderOfNumbers validator = new OrderOfNumbers( codeSecret);
        assertTrue(validator.verify(new Code(123)));
    }
    @Test
    void testValidatorWithRepeatedDigitsInSecretCode() {
        Code codeSecret = new Code(245);
        OrderOfNumbers validator = new OrderOfNumbers( codeSecret);
        assertTrue(validator.verify(new Code(123)));
    }
    @Test
    void testValidatorWithRepeatedDigitsInInputCode() {
        Code codeSecret = new Code(123);
        OrderOfNumbers validator = new OrderOfNumbers( codeSecret);
        assertFalse(validator.verify(new Code(122)));
    }

}