package ch.heigvd.gen.monopoly.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void createBoard(){
        board = new Board();
    }

    @Test
    public void testSquareNameGo(){
        Square square = board.getSquare(0);
        assertEquals("Go", square.getName());
    }

    @Test
    public void testSquaresName() {
        for(int i = 1; i < 40; i++){
            String str = "Square " + i;
            assertEquals(str,  board.getSquare(i).getName());
        }
    }

    @Test
    public void testGoToDesiredSquare() {
        Square go = new Square("Go");
        assertEquals("Square 2",board.getSquare(go, 2).getName());
        assertEquals("Square 10",board.getSquare(go, 10).getName());
    }

    @Test
    public void testFaceNotInLimits() {
        Square go = new Square("Go");
        assertNull(board.getSquare(go, 1));
        assertNull(board.getSquare(go, 13));
    }

    @Test
    public void testSquareNull() {
        Square go = null;
        assertNull(board.getSquare(go, 2));
    }

    @Test
    public void testSquareNotInBoard() {
        Square go = new Square("SquareUnknown");
        assertNull(board.getSquare(go, 2));
    }
}