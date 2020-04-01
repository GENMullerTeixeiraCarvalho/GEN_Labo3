package ch.heigvd.gen.monopoly.pieces;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DieTest {
    private Die die;

    @BeforeEach
    public void createDie(){
        die = new Die();
    }

    @Test
    public void testFaceValueDefault() {
        assertEquals(1, die.getFaceValue());
    }

    @RepeatedTest(10)
    public void testRoll() {
        die.roll();
        assertTrue(die.getFaceValue() <= 6, "Error roll is too high");
        assertTrue(die.getFaceValue() >= 1, "Error roll is too low");
    }
}