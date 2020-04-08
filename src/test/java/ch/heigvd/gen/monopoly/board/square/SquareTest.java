package ch.heigvd.gen.monopoly.board.square;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {
    @Test
    public void testGoSquareName() {
        Square go = new GoSquare();
        assertEquals("Go", go.getName());
    }

    @Test
    public void testJailSquareName() {
        Square jail = new GoToJailSquare();
        assertEquals("Jail", jail.getName());
    }

    @Test
    public void testIncomeTaxSquareName() {
        Square incomeTax = new IncomeTaxSquare();
        assertEquals("IncomeTax", incomeTax.getName());
    }
}