package ch.heigvd.gen.monopoly.board;

public class Board {
    private final static int MAX_SQUARES = 40;
    private Square[] squares = new Square[MAX_SQUARES];

    public Board(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < MAX_SQUARES; i++){
            if(i == 0){
                    str.append("Go");
            }
            else {
                str.append("Square ");
                str.append(i);
            }
            squares[i] = new Square(str.toString());
            str.delete(0, str.length());
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
}
