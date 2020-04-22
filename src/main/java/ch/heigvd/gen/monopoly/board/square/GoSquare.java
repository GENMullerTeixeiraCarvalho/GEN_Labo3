package ch.heigvd.gen.monopoly.board.square;

import ch.heigvd.gen.monopoly.Player;

/**
 * Representation of the Go square in a monopoly board
 * @author Müller Robin, Teixeira Carvalho Stéphane
 */
public class GoSquare extends Square {
    private static final int CASH_INCOME = 200;

    /**
     * Default constructor of the GoSquare that sets the square name to "Go"
     */
    public GoSquare() {
        super("Go");
    }

    /**
     * Override of the landedOn function that adds money to the player that landed on the square
     * @param p player that landed on this square
     */
    @Override
    public void landedOn(Player p) {
        p.addCash(CASH_INCOME);
    }
}
