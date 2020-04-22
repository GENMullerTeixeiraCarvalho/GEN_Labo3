package ch.heigvd.gen.monopoly;

import ch.heigvd.gen.monopoly.board.square.Square;
import ch.heigvd.gen.monopoly.pieces.Cup;
import ch.heigvd.gen.monopoly.pieces.Piece;
import ch.heigvd.gen.monopoly.board.Board;

/**
 * Class Player that represents the players of a Monopoly game
 * @author Müller Robin, Teixeira Carvalho Stéphane
 */
public class Player {
    private final static int INITIAL_CASH = 1500;

    private String name;
    private Piece piece;
    private Board board;
    private Cup cup;
    private int cash;

    /**
     * Specific constructor of the class Player
     * @param name String that defines the name of the player
     * @param go Square that represents the starting square
     * @param board Board that is the board of the game
     * @param cup object cup that is the cup containing the dice of the game
     */
    public Player(String name, Square go, Board board, Cup cup) {
        this.name = name;
        this.piece = new Piece(go);
        this.board = board;
        this.cup = cup;
        this.cash = INITIAL_CASH;
    }

    /**
     * Simulate the turn of the player
     */
    public void takeTurn() {
        int fvTot = 0;

        cup.roll();
        fvTot = cup.getTotal();

        Square oldLoc = piece.getLocation();
        try {
            //Get the new location of the piece
            Square newLoc = board.getSquare(oldLoc, fvTot);
            if (newLoc == null) {
                System.out.println("Impossible to get the new Square");
            } else {
                //Set the new location of the piece
                piece.setLocation(newLoc);
                
                newLoc.landedOn(this);
            }
        } catch(IllegalArgumentException ex){
            System.out.println(ex.toString());
        }
    }

    /**
     * Get the current cash of the player
     * @return int that is the current cash of the player
     */
    public int getCash() {
        return cash;
    }

    public int getNetWorth() { return getCash(); }

    /**
     * Add money to the cash of the player
     * @param cashToAdd int that is the amount of money to add
     * @throws IllegalArgumentException if cashToAdd is below or egal to 0
     */
    public void addCash(int cashToAdd) {
        if (cashToAdd <= 0)
            throw new IllegalArgumentException("cashToAdd must be a positive higher than 0 integer");

        this.cash += cashToAdd;
    }

    /**
     * Remove money to the cash of the player
     * @param cashToRemove int that is the amount of money to remove
     * @throws IllegalArgumentException if cashToAdd is below or egal to 0
     */
    public void reduceCash(int cashToRemove) {
        if (cashToRemove <= 0)
            throw new IllegalArgumentException("cashToRemove must be a positive higher than 0 integer");

        this.cash -= cashToRemove;
    }
}
