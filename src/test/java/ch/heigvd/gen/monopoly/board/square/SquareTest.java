package ch.heigvd.gen.monopoly.board.square;

import ch.heigvd.gen.monopoly.Player;
import ch.heigvd.gen.monopoly.board.Board;
import ch.heigvd.gen.monopoly.pieces.Cup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {
    private Player p;

    @BeforeEach
    public void initPlayer() {
        Board b = new Board();
        Cup cup = new Cup(2);

        p = new Player("Player0", b.getSquare(0), b, cup);
    }

    @Test
    public void testGoSquareName() {
        Square go = new GoSquare();
        assertEquals("Go", go.getName());
    }

    @Test
    public void testJailSquareName() {
        Square jail = new GoToJailSquare();
        assertEquals("Jail", jail.getName());
    }

    @Test
    public void testIncomeTaxSquareName() {
        Square incomeTax = new IncomeTaxSquare();
        assertEquals("IncomeTax", incomeTax.getName());
    }

    @Test
    public void testGoSquareLandedOn() {
        final int cash = 1500 + 200;

        Square go = new GoSquare();
        go.landedOn(p);
        assertEquals(p.getCash(), cash);
    }

    @Test
    public void testIncomeSquareLandedOnPercent() {
        final int cash = 1500;

        IncomeTaxSquare tax = new IncomeTaxSquare();
        tax.landedOn(p);
        assertEquals(p.getCash(), 1500 - (1500 * 0.1));
    }

    @Test
    public void testIncomeSquareLandedOnMaxAmount() {
        p.addCash(1500);
        final int initialCash = p.getCash();

        IncomeTaxSquare tax = new IncomeTaxSquare();
        tax.landedOn(p);
        assertEquals(p.getCash(), initialCash - 200);
    }
}