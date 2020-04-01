package ch.heigvd.gen.monopoly;

import ch.heigvd.gen.monopoly.board.Square;
import ch.heigvd.gen.monopoly.pieces.Piece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MGameTest {
    @Test
    public void testGameRun() {
        MGame mgame = new MGame(4);
        mgame.playGame();
    }
}
