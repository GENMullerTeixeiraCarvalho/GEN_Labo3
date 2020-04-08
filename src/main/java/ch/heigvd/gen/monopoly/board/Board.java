package ch.heigvd.gen.monopoly.board;

import ch.heigvd.gen.monopoly.board.square.*;

public class Board {
    private final static int MAX_SQUARES = 40;
    private Square[] squares = new Square[MAX_SQUARES];

    public Board(){
        StringBuilder str = new StringBuilder();
        squares[0] = new GoSquare();
        squares[4] = new IncomeTaxSquare();
        squares[30] = new GoToJailSquare();

        for(int i = 0; i < MAX_SQUARES; i++){
            if (squares[i] == null)
                squares[i] = new RegularSquare(i);
        }
    }

    public Square getSquare(Square oldLoc, int fvTot) {
        if(oldLoc == null || fvTot < 2 || fvTot > 12){
            return null;
        }
        int position;
        for(int i = 0; i < MAX_SQUARES; i++){
            if(oldLoc.getName().equals(squares[i].getName())){
                //The modulo is for the addition to not pass the array if a player arrives
                //at case 39 + 2 it will go to the square at position 1
                position = (i + fvTot) % MAX_SQUARES;
                return squares[position];
            }
        }
        return null;
    }

    public Square getSquare(int position) {
        if(position < 0 || position > MAX_SQUARES){
            return null;
        }
        return squares[position];
    }
}
