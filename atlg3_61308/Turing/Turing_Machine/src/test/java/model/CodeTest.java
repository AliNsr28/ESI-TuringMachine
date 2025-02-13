package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeTest {

    @Test
    void testConstructor_ValidCode() {
        Code code = new Code(123);
        assertNotNull(code);
        assertEquals(123, code.getCode());
    }

    @Test
    void testConstructor_InvalidCode() {
        assertThrows(TuringException.class, () -> new Code(526));
    }

    @Test
    void testGetHundreds() {
        Code code = new Code(345);
        assertEquals(3, code.getHundred());
    }

    @Test
    void testGetTens() {
        Code code = new Code(345);
        assertEquals(4, code.getTen());
    }

    @Test
    void testGetUnits() {
        Code code = new Code(345);
        assertEquals(5, code.getUnit());
    }


    @Test
    void testBoundaryValues() {
        assertDoesNotThrow(() -> new Code(111));
        assertDoesNotThrow(() -> new Code(555));
    }
}