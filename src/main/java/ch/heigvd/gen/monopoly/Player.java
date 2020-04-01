package ch.heigvd.gen.monopoly;

import ch.heigvd.gen.monopoly.board.Square;
import ch.heigvd.gen.monopoly.pieces.Die;
import ch.heigvd.gen.monopoly.pieces.Piece;
import ch.heigvd.gen.monopoly.board.Board;

public class Player {
    private static final int NB_DICE = 2;

    private String name;
    private Piece piece;
    private Board board;
    private Die[] dice;

    public Player(String name, Square go, Board board, Die[] dice) {
        if (dice.length > NB_DICE)
            throw new IllegalArgumentException(String.format("The maximum number of dice is %d", NB_DICE));

        this.name = name;
        this.piece = new Piece(go);
        this.board = board;
        this.dice = dice;
    }

    public void takeTurn() {
        int fvTot = 0;

        for (Die d : dice) {
            d.roll();
            fvTot += d.getFaceValue();
        }

        Square oldLoc = piece.getLocation();
        Square newLoc = board.getSquare(oldLoc, fvTot);
        piece.setLocation(newLoc);
    }
}
