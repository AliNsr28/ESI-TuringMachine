package model.validator;

import model.Code;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountValueNumberTest {
    @Test
    void testValidator8NoOneInCodeAndSecret() {
        Code codeSecret = new Code(235);
        CountValueNumber validator = new CountValueNumber(codeSecret,1);
        assertTrue(validator.verify(new Code(455)));
    }

    @Test
    void testValidator8OneOneInCodeAndSecret() {
        Code codeSecret = new Code(143);
        CountValueNumber validator = new CountValueNumber( codeSecret,1);
        assertTrue(validator.verify(new Code(321)));
    }

    @Test
    void testValidator8TwoOnesInCodeAndSecret() {
        Code codeSecret = new Code(511);
        CountValueNumber validator = new CountValueNumber(codeSecret,1);
        assertTrue(validator.verify(new Code(311)));
    }

    @Test
    void testValidator8ThreeOnesInCodeAndSecret() {
        Code codeSecret = new Code(111);
        CountValueNumber validator = new CountValueNumber( codeSecret,1);
        assertTrue(validator.verify(new Code(111)));
    }

    @Test
    void testValidator9NoThreeInCodeAndSecret() {
        Code codeSecret = new Code(254);
        CountValueNumber validator = new CountValueNumber(codeSecret,3 );
        assertTrue(validator.verify(new Code(421)));
    }

    @Test
    void testValidator9OneThreeInCodeAndSecret() {
        Code codeSecret = new Code(353);
        CountValueNumber validator = new CountValueNumber( codeSecret,3);
        assertTrue(validator.verify(new Code(313)));
    }

    @Test
    void testValidator9TwoThreesInCodeAndSecret() {
        Code codeSecret = new Code(353);
        CountValueNumber validator = new CountValueNumber( codeSecret,3);
        assertFalse(validator.verify(new Code(333)));
    }

    @Test
    void testValidator10NoFourInCodeAndSecret() {
        Code codeSecret = new Code(145);
        CountValueNumber validator = new CountValueNumber( codeSecret,4);
        assertFalse(validator.verify(new Code(312)));
    }

    @Test
    void testValidator10OneFourInCodeAndSecret() {
        Code codeSecret = new Code(451);
        CountValueNumber validator = new CountValueNumber( codeSecret,4);
        assertTrue(validator.verify(new Code(124)));
    }

    @Test
    void testValidator10TwoFoursInCodeAndSecret() {
        Code codeSecret = new Code(344);
        CountValueNumber validator = new CountValueNumber( codeSecret,4);
        assertFalse(validator.verify(new Code(444)));
    }








}