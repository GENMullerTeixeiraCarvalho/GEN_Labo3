package ch.heigvd.gen.monopoly.board.square;

import ch.heigvd.gen.monopoly.Player;

/**
 * Representation of the Go to jail Square in a Monopoly Board
 * @author Müller Robin, Teixeira Carvalho Stéphane
 */
public class GoToJailSquare extends Square {
    private final Square jail;

    /**
     * Default constructor of GoToJailSquare that takes the jail square as argument
     * @param jail square that represents the jail
     */
    public GoToJailSquare(Square jail) {
        super("GoToJail");
        this.jail = jail;
    }

    /**
     * Override of the landedOn function that changes the location of the
     * player to the jail Square
     * @param p player that landed on this square
     */
    @Override
    public void landedOn(Player p) {
        p.setLocation(jail);
    }
}
