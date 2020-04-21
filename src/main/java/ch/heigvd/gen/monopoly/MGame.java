package ch.heigvd.gen.monopoly;

import ch.heigvd.gen.monopoly.board.Board;
import ch.heigvd.gen.monopoly.pieces.Die;

/**
 * Class MGame that simulates a game of monopoly
 * @author Müller Robin, Teixeira Carvalho Stéphane
 */
public class MGame {
    private static final int NB_ROUNDS = 20;
    private static final int NB_DICE = 2;
    private int roundCnt;
    private Board board;
    private Die[] dice;
    private Player[] players;

    /**
     * Specific constructor of MGame
     * @param nbPlayers int that is the number of players for the game
     * @throws IllegalArgumentException if the number of players is below 2 or higher than 8
     */
    public MGame(int nbPlayers){
        //Check if the number of players is correct
        if(nbPlayers < 2 || nbPlayers > 8){
            throw new IllegalArgumentException("Number of players has to be between 2 and 8");
        }
        this.roundCnt = 0;
        this.board = new Board();
        this.dice = new Die[2];
        //Creates the dice for the game
        for(int i = 0; i < NB_DICE; i++){
            dice[i] = new Die();
        }
        this.players = new Player[nbPlayers];
        //Int that will be the number of the players
        int playerNumber = 1;
        //Create the players
        for(int i = 0; i < nbPlayers; i++) {
            players[i] = new Player("Player " + playerNumber, board.getSquare(0), board, dice);
            playerNumber++;
        }
    }

    /**
     * Function that will play the game
     */
    public void playGame(){
        while(roundCnt < NB_ROUNDS){
            playRound();
            roundCnt++;
        }
    }

    /**
     * Function that will play a round
     */
    private void playRound(){
        //Each player take one turn
        for(int i = 0; i < players.length; i++){
            players[i].takeTurn();
        }
    }

}
