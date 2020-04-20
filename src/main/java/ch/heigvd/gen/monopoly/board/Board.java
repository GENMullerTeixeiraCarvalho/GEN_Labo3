package ch.heigvd.gen.monopoly.board;

/**
 * Class Board representing the board in the Monopoly Game.
 * Can give the square of the board.
 * @author Müller Robin, Teixeira Carvalho Stéphane
 */
public class Board {
    private final static int MAX_SQUARES = 40;
    private Square[] squares = new Square[MAX_SQUARES];

    /**
     * Constructor by default of the class Board. This will construct the squares
     */
    public Board(){
        StringBuilder str = new StringBuilder();
        //Loop that creates the different squares
        for(int i = 0; i < MAX_SQUARES; i++){
            if(i == 0){
                str.append("Go");
            }
            else {
                str.append("Square ");
                str.append(i);
            }
            //Create the square and pass the name contained in the StringBuilder
            squares[i] = new Square(str.toString());
            //Delete all the character contained in the StringBuilder
            str.delete(0, str.length());
        }
    }

    /**
     * Returns the square of destination starting from a square and the number of square to jump
     * @param oldLoc Square representing the sarting square
     * @param fvTot int being the number of square to jump
     * @return a square that is the square of destination or null if parameter is incorrect
     */
    public Square getSquare(Square oldLoc, int fvTot) {
        //Verification that parameters are valid
        if(oldLoc == null || fvTot < 2 || fvTot > 12){
            throw new IllegalArgumentException("Square cannot be null and faceValue total can only be between 2 and 12");
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
        //If square does not exist null is returned
        return null;
    }

    /**
     * Overload of the function getSquare to be able to return a square from a postion desired
     * @param position int being the position of the wanted square
     * @return Square in the postion given null if parameters are incorrect
     */
    public Square getSquare(int position) {
        if(position < 0 || position > MAX_SQUARES){
            return null;
        }
        return squares[position];
    }
}
