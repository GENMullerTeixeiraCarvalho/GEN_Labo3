package ch.heigvd.gen.monopoly.board;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {
    @Test
    public void testSquareName() {
        Square go = new Square("Go");
        assertEquals("Go", go.getName());
    }
}