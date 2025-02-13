package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.CSVReader;

import static org.junit.jupiter.api.Assertions.*;

class ProblemTest {
    private Problem problem;
    private  int validProblemNumber = 1;// Adjust with a valid problem number

    private CSVReader csvReader = new CSVReader();

    @BeforeEach
    void setUp() {
        problem =  csvReader.getProblems().get(0);
    }

    @Test
    void testConstructor() {
        assertNotNull(problem);
        assertEquals(241, problem.getCode().getCode());
        assertFalse(problem.getValidators().isEmpty());
    }

    @Test
    void testConstructor2() {
        assertNotNull(problem);
        assertEquals(4, problem.getValidators().size());
    }



}
