package ch.heigvd.gen.monopoly;

import ch.heigvd.gen.monopoly.board.Square;
import ch.heigvd.gen.monopoly.pieces.Die;
import ch.heigvd.gen.monopoly.pieces.Piece;
import ch.heigvd.gen.monopoly.board.Board;

public class Player {
    private String name;
    private Piece piece;
    private Board board;
    private Die[] dice;

    public Player(String name, Square go, Board board, Die[] dice) {
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
