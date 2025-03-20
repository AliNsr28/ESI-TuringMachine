package model.validator;

import model.Code;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountTheNumbersPeersTest {
    @Test
    void testValidator17ZeroEvenInCodeAndSecret() {
        Code codeSecret = new Code(135);
        CountTheNumbersPeers validator = new CountTheNumbersPeers( codeSecret);
        assertTrue(validator.verify(new Code(311)));
    }

    @Test
    void testValidator17OneEvenInCodeAndSecret() {
        Code codeSecret = new Code(213);
        CountTheNumbersPeers validator = new CountTheNumbersPeers( codeSecret);
        assertTrue(validator.verify(new Code(312)));
    }

    @Test
    void testValidator17TwoEvenInCodeAndSecret() {
        Code codeSecret = new Code(135);
        CountTheNumbersPeers validator = new CountTheNumbersPeers( codeSecret);
        assertFalse(validator.verify(new Code(241)));
    }

    @Test
    void testValidator17ThreeEvenInCodeAndSecret() {
        Code codeSecret = new Code(244);
        CountTheNumbersPeers validator = new CountTheNumbersPeers( codeSecret);
        assertTrue(validator.verify(new Code(242)));
    }
    @Test
    void testValidator17ThreeEvenInCodeAndSecretWrong() {
        Code codeSecret = new Code(214);
        CountTheNumbersPeers validator = new CountTheNumbersPeers( codeSecret);
        assertFalse(validator.verify(new Code(242)));
    }






    @Test
    void testValidator17ZeroEvenInCodeOneEvenInSecret() {
        Code codeSecret = new Code(125);
        CountTheNumbersPeers validator = new CountTheNumbersPeers( codeSecret);
        assertFalse(validator.verify(new Code(351)));
    }

    @Test
    void testValidator17TwoEvenInCodeOneEvenInSecret() {
        Code codeSecret = new Code(245);
        CountTheNumbersPeers validator = new CountTheNumbersPeers( codeSecret);
        assertTrue(validator.verify(new Code(412)));
    }

    @Test
    void testValidator17TwoEvenInCodeTwoEvenInSecret() {
        Code codeSecret = new Code(432);
        CountTheNumbersPeers validator = new CountTheNumbersPeers(codeSecret);
        assertTrue(validator.verify(new Code(234)));
    }

    @Test
    void testValidator17OneEvenInCodeTwoEvenInSecret() {
        Code codeSecret = new Code(245);
        CountTheNumbersPeers validator = new CountTheNumbersPeers( codeSecret);
        assertFalse(validator.verify(new Code(332)));
    }

    @Test
    void testValidator17ThreeEvenInCodeTwoEvenInSecret() {
        Code codeSecret = new Code(245);
        CountTheNumbersPeers validator = new CountTheNumbersPeers( codeSecret);
        assertFalse(validator.verify(new Code(444)));
    }


}