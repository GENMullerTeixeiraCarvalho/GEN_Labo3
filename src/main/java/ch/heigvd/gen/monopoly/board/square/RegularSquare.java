package ch.heigvd.gen.monopoly.board.square;

import ch.heigvd.gen.monopoly.Player;

/**
 * Representation of a regual square for a Monopoly game
 * @author Müller Robin, Teixeira Carvalho Stéphane
 */
public class RegularSquare extends Square {
    /**
     * Specific constructor of RegularSquare that concatenates ("Square " + i) as name
     * @param i id of the square
     */
    public RegularSquare(int i) {
        super("Square " + i);
    }

    /**
     * Override of function landedOn with no action.
     * @param p player that landed on this square
     */
    @Override
    public void landedOn(Player p) {

    }
}
