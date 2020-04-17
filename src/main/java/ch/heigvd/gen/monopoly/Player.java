package ch.heigvd.gen.monopoly;

import ch.heigvd.gen.monopoly.board.square.Square;
import ch.heigvd.gen.monopoly.pieces.Die;
import ch.heigvd.gen.monopoly.pieces.Piece;
import ch.heigvd.gen.monopoly.board.Board;

public class Player {
    private final static int INITIAL_CASH = 1500;

    private String name;
    private Piece piece;
    private Board board;
    private Die[] dice;
    private int cash;

    public Player(String name, Square go, Board board, Die[] dice) {
        this.name = name;
        this.piece = new Piece(go);
        this.board = board;
        this.dice = dice;
        this.cash = INITIAL_CASH;
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

    public int getCash() {
        return cash;
    }

    public int getNetWorth() { return getCash(); }

    public void addCash(int cashToAdd) {
        if (cashToAdd <= 0)
            throw new IllegalArgumentException("cashToAdd must be a positive higher than 0 integer");

        this.cash += cashToAdd;
    }

    public void reduceCash(int cashToRemove) {
        if (cashToRemove <= 0)
            throw new IllegalArgumentException("cashToRemove must be a positive higher than 0 integer");

        this.cash -= cashToRemove;
    }
}
