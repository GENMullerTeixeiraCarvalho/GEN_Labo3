package ch.heigvd.gen.monopoly.pieces;

import ch.heigvd.gen.monopoly.board.square.GoSquare;
import ch.heigvd.gen.monopoly.board.square.RegularSquare;
import ch.heigvd.gen.monopoly.board.square.Square;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {
    @Test
    public void testConstructorPieceLocation() {
        Square go = new GoSquare();
        Piece p = new Piece(go);
        assertEquals(p.getLocation(), go);
    }

    @Test
    public void testSetPieceLocation() {
        Square go = new GoSquare();
        Square square5 = new RegularSquare(5);

        Piece p = new Piece(go);
        p.setLocation(square5);

        assertEquals(p.getLocation(), square5);
    }
}
