package ch.heigvd.gen.monopoly.board;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testSquareNameGo() {
        Square square = new Square("Square 38");
        Board board = new Board();
        square = board.getSquare(square, 2);
        assertEquals("Go", square.getName());
    }

    @Test
    public void testSquaresEvenName() {
        Square square = new Square("Square 2");
        Board board = new Board();
        int squareNumber = 2;
        for(int i = 0; i < 18; i++){
            String str = "Square " + squareNumber;
            assertEquals(str, square.getName());
            square = board.getSquare(square, 2);
            squareNumber += 2;
        }
    }

    @Test
    public void testSquaresOddName() {
        Square square = new Square("Square 1");
        Board board = new Board();
        int squareNumber = 1;
        for(int i = 0; i < 18; i++){
            String str = "Square " + squareNumber;
            assertEquals(str, square.getName());
            square = board.getSquare(square, 2);
            squareNumber += 2;
        }
    }

    @Test
    public void TestGoToDesiredSquare() {
        Square go = new Square("Go");
        Board board = new Board();
        assertEquals("Square 2",board.getSquare(go, 2).getName());
        assertEquals("Square 10",board.getSquare(go, 10).getName());
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