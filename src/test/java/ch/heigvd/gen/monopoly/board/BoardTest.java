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
    public void testFaceValueNotInLimits() {
        Square go = new Square("Go");
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
        Square unknown = new Square("SquareUnknown");
        assertNull(board.getSquare(unknown, 2));
    }
}