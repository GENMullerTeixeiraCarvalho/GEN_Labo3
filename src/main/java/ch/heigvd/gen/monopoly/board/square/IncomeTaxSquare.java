package ch.heigvd.gen.monopoly.board.square;

import ch.heigvd.gen.monopoly.Player;

/**
 * Representation of the income tax square for a Monopoly game
 * @author Müller Robin, Teixeira Carvalho Stéphane
 */
public class IncomeTaxSquare extends Square {
    /**
    * Default constructor of the IncomeTaxSquare that sets the square name to "IncomeTax"
    */
    public IncomeTaxSquare() {
        super("IncomeTax");
    }

    /**
     * Override of the landedOn function that removes the minimum between 200 and 10% of
     * the player net worth from his cash
     * @param p player that landed on this square
     */
    @Override
    public void landedOn(Player p) {
        int w = p.getNetWorth();
        p.reduceCash(Math.min(200, (int)(w * 0.1)));
    }
}
