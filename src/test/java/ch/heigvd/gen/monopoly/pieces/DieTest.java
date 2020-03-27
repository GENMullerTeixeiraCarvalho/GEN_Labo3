package ch.heigvd.gen.monopoly.pieces;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DieTest {
    @Test
    public void testFaceValueDefault() {
        Die die = new Die();
        assertEquals(1, die.getFaceValue());
    }

    @RepeatedTest(10)
    public void testRoll() {
        Die die = new Die();
        die.roll();
        assertTrue(die.getFaceValue() <= 6, "Error roll is too high");
        assertTrue(die.getFaceValue() >= 1, "Error roll is too low");
    }
}