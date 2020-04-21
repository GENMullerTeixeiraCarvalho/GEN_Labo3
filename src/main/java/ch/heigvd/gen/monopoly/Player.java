package ch.heigvd.gen.monopoly;

import ch.heigvd.gen.monopoly.board.Square;
import ch.heigvd.gen.monopoly.pieces.Die;
import ch.heigvd.gen.monopoly.pieces.Piece;
import ch.heigvd.gen.monopoly.board.Board;

/**
 * Class Player that represents the players of a Monopoly game
 * @author Müller Robin, Teixeira Carvalho Stéphane
 */
public class Player {
    private String name;
    private Piece piece;
    private Board board;
    private Die[] dice;

    /**
     * Specific constructor of the class Player
     * @param name String that defines the name of the player
     * @param go Square that represents the starting square
     * @param board Board that is the board of the game
     * @param dice Array of Die that is the dice of the game
     */
    public Player(String name, Square go, Board board, Die[] dice) {
        this.name = name;
        this.piece = new Piece(go);
        this.board = board;
        this.dice = dice;
    }

    public void takeTurn() {
        int fvTot = 0;

        //Roll the 2 dice
        for (Die d : dice) {
            d.roll();
            fvTot += d.getFaceValue();
        }

        Square oldLoc = piece.getLocation();
        try {
            //Get the new location of the piece
            Square newLoc = board.getSquare(oldLoc, fvTot);
            if (newLoc == null) {
                System.out.println("Impossible to get the new Square");
            } else {
                //Set the new location of the piece
                piece.setLocation(newLoc);
            }
        } catch(IllegalArgumentException ex){
            System.out.println(ex.toString());
        }
    }
}
