package ch.heigvd.gen.monopoly;

import ch.heigvd.gen.monopoly.board.Board;
import ch.heigvd.gen.monopoly.board.square.Square;
import ch.heigvd.gen.monopoly.pieces.Die;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private Player p;

    @BeforeEach
    public void initPlayer() {
        Board b = new Board();
        Die[] dice = new Die[2];
        dice[0] = new Die();
        dice[1] = new Die();

        p = new Player("Player0", b.getSquare(0), b, dice);
    }

    @Test
    public void testInitialCash() {
        assertEquals(p.getCash(), 1500);
    }

    @ParameterizedTest
    @ValueSource (ints = {0, -1, -100})
    public void testInvalidAddCash(int amount) {
        assertThrows(IllegalArgumentException.class, () -> {
            p.addCash(amount);
        });
    }

    @ParameterizedTest
    @ValueSource (ints = {0, -1, -100})
    public void testInvalidRemoveCash(int amount) {
        assertThrows(IllegalArgumentException.class, () -> {
            p.removeCash(amount);
        });
    }

    @ParameterizedTest
    @ValueSource (ints = {100, 200, 250, 1500, 2000})
    public void testAddCash(int amount) {
        p.addCash(amount);

        assertEquals(p.getCash(), 1500 + amount);
    }

    @ParameterizedTest
    @ValueSource (ints = {100, 200, 250, 1500, 2000})
    public void testRemoveCash(int amount) {
        p.removeCash(amount);

        assertEquals(p.getCash(), 1500 - amount);
    }
}
