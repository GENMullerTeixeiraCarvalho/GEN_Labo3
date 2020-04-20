package ch.heigvd.gen.monopoly.pieces;

import ch.heigvd.gen.monopoly.board.Square;

/**
 * Class Piece that reprresnts the piece in a Monopoly Game.
 * The piece is represented by its square location
 * @author Müller Robin, Teixeira Carvalho Stéphane
 */
public class Piece {
    private Square location;

    /**
     * Specific constructor of Piece
     * @param location Square that is the square where the piece starts
     */
    public Piece(Square location) {
        this.location = location;
    }

    /**
     * Get the square where the piece is located
     * @return a Square that is the locatio of the piece
     */
    public Square getLocation() {
        return location;
    }

    /**
     * Set the location square for the piece
     * @param location Square that will be the new location square of the piece
     */
    public void setLocation(Square location) {
        this.location = location;
    }
}
