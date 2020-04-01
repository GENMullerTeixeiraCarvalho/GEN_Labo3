package ch.heigvd.gen.monopoly;

import ch.heigvd.gen.monopoly.board.Board;
import ch.heigvd.gen.monopoly.pieces.Die;

public class MGame {
    private static final int NB_ROUNDS = 20;
    private static final int NB_DICE = 2;
    private int roundCnt;
    private Board board;
    private Die[] dice;
    private Player[] players;

    public MGame(int nbPlayers){
        if(nbPlayers < 2 || nbPlayers > 8){
            throw new IllegalArgumentException("Number of players has to be between 2 and 8");
        }
        this.roundCnt = 0;
        this.board = new Board();
        this.dice = new Die[2];
        for(int i = 0; i < NB_DICE; i++){
            dice[i] = new Die();
        }
        this.players = new Player[nbPlayers];
        int playerNumber = 1;
        for(int i = 0; i < nbPlayers; i++) {
            players[i] = new Player("Player " + playerNumber, board.getSquare(0), board, dice);
            playerNumber++;
        }
    }

    public void playGame(){
        while(roundCnt < NB_ROUNDS){
            playRound();
            roundCnt++;
        }
    }

    private void playRound(){
        for(int i = 0; i < players.length; i++){
            players[i].takeTurn();
        }
    }

}
