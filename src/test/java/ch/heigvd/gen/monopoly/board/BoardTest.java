package ch.heigvd.gen.monopoly.board;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testSquareNameGo() {
        Board board = new Board();
        Square square = board.getSquare(0);
        assertEquals("Go", square.getName());
    }

    @Test
    public void testSquaresName() {
        Board board = new Board();
        for(int i = 1; i < 40; i++){
            String str = "Square " + i;
            assertEquals(str,  board.getSquare(i).getName());
        }
    }

    @Test
    public void testGoToDesiredSquare() {
        Square go = new Square("Go");
        Board board = new Board();
        assertEquals("Square 2",board.getSquare(go, 2).getName());
        assertEquals("Square 10",board.getSquare(go, 10).getName());
    }

    @Test
    public void testFaceNotInLimits() {
        Square go = new Square("Go");
        Board board = new Board();
        assertNull(board.getSquare(go, 1));
        assertNull(board.getSquare(go, 13));
    }

    @Test
    public void testSquareNull() {
        Square go = null;
        Board board = new Board();
        assertNull(board.getSquare(go, 2));
    }

    @Test
    public void testSquareNotInBoard() {
        Square go = new Square("SquareUnknown");
        Board board = new Board();
        assertNull(board.getSquare(go, 2));
    }
}