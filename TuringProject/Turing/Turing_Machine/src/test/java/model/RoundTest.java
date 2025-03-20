package model;

import model.validator.Validator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {
    private Round round =new Round();
    private Code secretCode = new Code(111);

    private Factory factory = new Factory();



    @Test
    void testConstructor() {
        assertTrue(round.getGoodvalidators().isEmpty());
        assertTrue(round.getGoodvalidators().isEmpty());
        assertEquals(0, round.getValidators().size());
    }



    @Test
    void testAddCode_AfterValidatorTest() {
        round.setUser(new Code(123));
        Validator validator = factory.addValidator(secretCode, 1);
        round.testValidator(validator);
        assertThrows(TuringException.class, () -> round.setUser(new Code(456)));
    }


    @Test
    void testValidator_Success() {
        Validator validator = factory.addValidator(secretCode,21);
        Validator validator1 = factory.addValidator(secretCode,2);
        Validator validator2 = factory.addValidator(secretCode,3);
        Validator validator3 = factory.addValidator(secretCode,4);

        List <Validator> validators = new ArrayList<>();

        validators.add(validator);
        validators.add(validator1);
        validators.add(validator2);
        validators.add(validator3);

        round.addValidators(validators);
        round.setUser(new Code(111));

        round.testValidator(validator);


        assertEquals(1, round.getGoodvalidators().size());
    }

    @Test
    void testValidator_NotSuccess() {
        Validator validator = factory.addValidator(secretCode,21);
        Validator validator1 = factory.addValidator(secretCode,2);
        Validator validator2 = factory.addValidator(secretCode,3);
        Validator validator3 = factory.addValidator(secretCode,4);

        List <Validator> validators = new ArrayList<>();

        validators.add(validator);
        validators.add(validator1);
        validators.add(validator2);
        validators.add(validator3);

        round.addValidators(validators);
        round.setUser(new Code(211));

        round.testValidator(validator);


        assertEquals(1, round.getBadvalidators().size());
    }



}