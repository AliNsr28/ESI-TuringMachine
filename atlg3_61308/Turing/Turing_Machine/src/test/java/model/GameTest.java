package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.CSVReader;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void testStartGame_ValidIndex() {
        game.startGame(new CSVReader(),1);
        assertFalse(game.isFind());
    }

    @Test
    void testStartGame_InvalidIndex() {
        assertThrows(TuringException.class, () -> game.startGame(new CSVReader(),17));
    }



    @Test
    void testEnterCode_WhenGameNotOver() {
        game.startGame(new CSVReader(),1);
        assertDoesNotThrow(() -> game.addCode(new Code(123))); // Assuming 123 is a valid code
    }

    @Test
    void testChooseValidator_WhenGameNotOver() {
        game.startGame(new CSVReader(),1);
        game.addCode(new Code(241));
        assertDoesNotThrow(() -> game.verificationCode(game.getUser())); // Assuming 0 is a valid validator index
    }



}