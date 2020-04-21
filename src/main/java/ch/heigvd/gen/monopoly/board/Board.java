package ch.heigvd.gen.monopoly.board;

import ch.heigvd.gen.monopoly.board.square.*;

public class Board {
    private final static int MAX_SQUARES = 40;
    private final static int POS_GO_SQUARE = 0;
    private final static int POS_INCOME_TAX_SQUARE = 4;
    private final static int POS_JAIL_SQUARE = 10;
    private final static int POS_GO_TO_JAIL_SQUARE = 30;

    private Square[] squares = new Square[MAX_SQUARES];

    public Board(){
        StringBuilder str = new StringBuilder();
        squares[POS_GO_SQUARE] = new GoSquare();
        squares[POS_INCOME_TAX_SQUARE] = new IncomeTaxSquare();

        for(int i = 0; i < MAX_SQUARES; i++){
            if (squares[i] == null || i == POS_GO_TO_JAIL_SQUARE)
                squares[i] = new RegularSquare(i);
        }

        squares[POS_GO_TO_JAIL_SQUARE] = new GoToJailSquare(squares[POS_JAIL_SQUARE]);
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
