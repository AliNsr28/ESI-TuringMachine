package model.validator;

import model.Code;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MostFrequentParityTest {
    @Test
    void testValidator17NoMostFrequentParityInCodeAndMostFrequentParityInSecret() {
        Code codeSecret = new Code(242);
        MostFrequentParity validator = new MostFrequentParity(codeSecret);
        assertFalse(validator.verify(new Code(135)));
    }

    @Test
    void testValidator17NoMostFrequentParityInSecret() {
        Code codeSecret = new Code(135);
        MostFrequentParity validator = new MostFrequentParity(codeSecret);
        assertFalse(validator.verify(new Code(245)));
    }

    @Test
    void testValidator17MostFrequentParityInCodeNoMostFrequentParityInSecret() {
        Code codeSecret = new Code(135);
        MostFrequentParity validator = new MostFrequentParity(codeSecret);
        assertFalse(validator.verify(new Code(214)));
    }

    @Test
    void testValidator17MostFrequentParityInCodeMostFrequentParityInSecret() {
        Code codeSecret = new Code(242);
        MostFrequentParity validator = new MostFrequentParity(codeSecret);
        assertTrue(validator.verify(new Code(245)));
    }


    @Test
    void testValidator5MostFrequentParityInCodeAndSecret() {
        Code codeSecret = new Code(122);
        MostFrequentParity validator = new MostFrequentParity(codeSecret);
        assertTrue(validator.verify(new Code(441)));
    }

    @Test
    void testValidator5NoMostFrequentParityInCodeAndSecret() {
        Code codeSecret = new Code(125);
        MostFrequentParity validator = new MostFrequentParity(codeSecret);
        assertTrue(validator.verify(new Code(134)));
    }

    @Test
    void testValidator5MostFrequentParityInCodeNoMostFrequentParityInSecret() {
        Code codeSecret = new Code(134);
        MostFrequentParity validator = new MostFrequentParity(codeSecret);
        assertFalse(validator.verify(new Code(234)));
    }

    @Test
    void testValidator5NoMostFrequentParityInCodeMostFrequentParityInSecret() {
        Code codeSecret = new Code(244);
        MostFrequentParity validator = new MostFrequentParity(codeSecret);
        assertFalse(validator.verify(new Code(231)));
    }
}



