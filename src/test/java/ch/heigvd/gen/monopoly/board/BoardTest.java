package ch.heigvd.gen.monopoly.board;

import ch.heigvd.gen.monopoly.board.square.GoSquare;
import ch.heigvd.gen.monopoly.board.square.RegularSquare;
import ch.heigvd.gen.monopoly.board.square.Square;
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
    public void testSquareSpecialNames(){
        assertEquals("Go", board.getSquare(0).getName());
        assertEquals("IncomeTax", board.getSquare(4).getName());
        assertEquals("Jail", board.getSquare(30).getName());
    }

    @Test
    public void testSquaresName() {
        for(int i = 1; i < 40; i++){
            if (board.getSquare(i) instanceof RegularSquare) {
                String str = "Square " + i;
                assertEquals(str, board.getSquare(i).getName());
            }
        }
    }

    @Test
    public void testGoToDesiredSquare() {
        Square go = new GoSquare();
        assertEquals("Square 2",board.getSquare(go, 2).getName());
        assertEquals("Square 10",board.getSquare(go, 10).getName());
    }

    @Test
    public void testFaceValueNotInLimits() {
        Square go = new GoSquare();
        assertThrows(IllegalArgumentException.class, () -> {
            board.getSquare(go,1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            board.getSquare(go,13);
        });
    }

    @Test
    public void testSquareNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            board.getSquare(null,2);
        });
    }

    @Test
    public void testSquareNotInBoard() {
        Square go = new RegularSquare(-1);
        assertNull(board.getSquare(go, 2));
    }
}