package ch.heigvd.gen.monopoly.board;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testSquaresName() {
        Square square = new Square("Go");
        Board board = new Board();
        int position = 2;
        boolean tourFini = false;
        square = board.getSquare(square, 2);
        for(int i = 0; i < 39; i++){
            String str = "Square " + position;
            assertEquals(str, square.getName());
            if(!tourFini) {
                position = (position + 2) % 39;
            }
            else {
                position = (position + 2) % 41;
            }
            if(position == 1){
                square = board.getSquare(square, 3);
                tourFini = true;
            }
            else {
                square = board.getSquare(square, 2);
            }
        }
    }

    @Test
    public void TestGoToDesiredSquare() {
        Square go = new Square("Go");
        Board board = new Board();
        assertEquals("Square 2",board.getSquare(go, 2).getName());
    }

    @Test
    public void TestFaceNotInLimits() {
        Square go = new Square("Go");
        Board board = new Board();
        assertNull(board.getSquare(go, 1));
        assertNull(board.getSquare(go, 13));
    }

    @Test
    public void TestSquareNull() {
        Square go = null;
        Board board = new Board();
        assertNull(board.getSquare(go, 2));
    }

    @Test
    public void TestSquareNotInBoard() {
        Square go = new Square("SquareUnknown");
        Board board = new Board();
        assertNull(board.getSquare(go, 2));
    }
}