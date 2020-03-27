package ch.heigvd.gen.monopoly.pieces;

import ch.heigvd.gen.monopoly.board.Square;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {
    @Test
    public void testConstructorPieceLocation() {
        Square go = new Square("Go");
        Piece p = new Piece(go);
        assertEquals(p.getLocation(), go);
    }

    @Test
    public void testSetPieceLocation() {
        Square go = new Square("Go");
        Square square5 = new Square("Square 5");

        Piece p = new Piece(go);
        p.setLocation(square5);

        assertEquals(p.getLocation(), square5);
    }
}
