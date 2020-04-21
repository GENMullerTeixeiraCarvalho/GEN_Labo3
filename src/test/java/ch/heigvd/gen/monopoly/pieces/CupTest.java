package ch.heigvd.gen.monopoly.pieces;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CupTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    public void testIllegalValueDice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cup(0);
        });
    }

    @Test
    public void testDiceRolling(){
        Cup c = new Cup(2);
        c.roll();
        assertNotEquals(0, c.getTotal());
    }
}
