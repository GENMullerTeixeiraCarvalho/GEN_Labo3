package ch.heigvd.gen.monopoly;

import ch.heigvd.gen.monopoly.board.Board;
import ch.heigvd.gen.monopoly.pieces.Cup;

/**
 * Class MGame that simulates a game of monopoly
 * @author Müller Robin, Teixeira Carvalho Stéphane
 */
public class MGame {
    private static final int NB_ROUNDS = 20;
    private static final int NB_DICE = 2;
    private int roundCnt;
    private Board board;
    private Cup cup;
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
        this.cup = new Cup(NB_DICE);
        this.players = new Player[nbPlayers];
        //Int that will be the number of the players
        int playerNumber = 1;
        //Create the players
        for(int i = 0; i < nbPlayers; i++) {
            players[i] = new Player("Player " + playerNumber, board.getSquare(0), board, cup);
            playerNumber++;
        }
    }

    /**
     * Function that will play the game
     */
    public void playGame(){
        System.out.println("Starting a game");
        while(roundCnt < NB_ROUNDS){
            System.out.println(String.format("\n------ Beginning of round %d ------", roundCnt + 1));
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
            System.out.println("\n----- New round -----");
            players[i].takeTurn();
        }
    }

    public static void main(String[] args) {
        final int NB_PLAYERS = 4;
        MGame mGame = new MGame(NB_PLAYERS);
        mGame.playGame();
    }
}
