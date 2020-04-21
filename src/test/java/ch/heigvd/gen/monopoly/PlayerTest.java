package ch.heigvd.gen.monopoly;

import ch.heigvd.gen.monopoly.board.Board;
import ch.heigvd.gen.monopoly.pieces.Cup;
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
        Cup cup = new Cup(2);

        p = new Player("Player0", b.getSquare(0), b, cup);
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
            p.reduceCash(amount);
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
        p.reduceCash(amount);

        assertEquals(p.getCash(), 1500 - amount);
    }

    @Test
    public void testGetNetWorth() {
        assertEquals(p.getNetWorth(), 1500);
        p.reduceCash(1000);
        assertEquals(p.getNetWorth(), 1500 - 1000);
    }
}
