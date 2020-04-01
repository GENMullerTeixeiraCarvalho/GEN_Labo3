package ch.heigvd.gen.monopoly.board;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {
    @Test
    public void testSquareName() {
        Square go = new Square("Go");
        Square square1 = new Square("Square 1");
        assertEquals("Go", go.getName());
        assertEquals("Square 1", square1.getName());
    }
}