package model.validator;

import model.Code;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtremeFigureTest {
    @Test
    void testValidator14BlueIsSmallerThanBothPurpleAndYellow() {
        Code codeSecret = new Code(124);
        ExtremeFigure validator = new ExtremeFigure(codeSecret ,true);
        assertFalse(validator.verify(new Code(325)));
    }
    @Test
    void testValidator14Ok() {
        Code codeSecret = new Code(234);
        ExtremeFigure validator = new ExtremeFigure(codeSecret ,false);
        assertTrue(validator.verify(new Code(315)));
    }

    @Test
    void testValidator14WithDuplicates() {
        Code codeSecret = new Code(232);
        ExtremeFigure validator = new ExtremeFigure( codeSecret,false);
        assertFalse(validator.verify(new Code(315)));
    }
    @Test
    void testValidator14YellowIsSmallerThanBothBlueAndPurple() {
        Code codeSecret = new Code(432);
        ExtremeFigure validator = new ExtremeFigure( codeSecret,true);
        assertTrue(validator.verify(new Code(251)));
    }

    @Test
    void testValidator14PurpleIsSmallerThanBothBlueAndYellow() {
        Code codeSecret = new Code(315);
        ExtremeFigure validator = new ExtremeFigure( codeSecret , true);
        assertTrue(validator.verify(new Code(412)));
    }

    @Test
    void testValidator14NoExtremeFigureInCodeAndSecret() {
        Code codeSecret = new Code(111);
        ExtremeFigure validator = new ExtremeFigure( codeSecret , true);
        assertTrue(validator.verify(new Code(111)));
    }

    @Test
    void testValidator15BlueIsLargerThanBothPurpleAndYellow() {
        Code codeSecret = new Code(432);
        ExtremeFigure validator = new ExtremeFigure(codeSecret , true);
        assertTrue(validator.verify(new Code(321)));
    }

    @Test
    void testValidator15YellowIsLargerThanBothBlueAndPurple() {
        Code codeSecret = new Code(124);
        ExtremeFigure validator = new ExtremeFigure( codeSecret , false);
        assertTrue(validator.verify(new Code(325)));
    }

    @Test
    void testValidator15PurpleIsLargerThanBothBlueAndYellow() {
        Code codeSecret = new Code(315);
        ExtremeFigure validator = new ExtremeFigure( codeSecret , false);
        assertTrue(validator.verify(new Code(224)));
    }

    @Test
    void testValidator15NoExtremeFigureInCodeAndSecret() {
        Code codeSecret = new Code(111);
        ExtremeFigure validator = new ExtremeFigure( codeSecret , false);
        assertTrue(validator.verify(new Code(111)));
    }




    /*
    @Test
    void testStringCategoryValidator14() {
        ExtremeFigure validator = new ExtremeFigure(14, new Code(123));
        assertEquals("blue is smaller than both purple and yellow | "
                + "yellow is smaller than both blue and purple | "
                + "purple is smaller than both blue and yellow", validator.stringCategory());
    }

    @Test
    void testStringCategoryValidator15() {
        ExtremeFigure validator = new ExtremeFigure(15, new Code(123));
        assertEquals("blue is larger than both purple and yellow | "
                + "yellow is larger than both blue and purple | "
                + "purple is larger than both blue and yellow", validator.stringCategory());
    }
    */


}