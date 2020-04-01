package ch.heigvd.gen.monopoly;

import ch.heigvd.gen.monopoly.board.Board;
import ch.heigvd.gen.monopoly.board.Square;
import ch.heigvd.gen.monopoly.pieces.Die;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testErrorTooManyDice() {
        Die d1 = new Die();
        Die d2 = new Die();
        Die d3 = new Die();
        Die[] dice = new Die[] {d1, d2, d3};

        Board board = new Board();
        Square square = new Square("Go");

        assertThrows(IllegalArgumentException.class, () -> {
           new Player("PlayerName", square, board, dice);
        });
    }
}
