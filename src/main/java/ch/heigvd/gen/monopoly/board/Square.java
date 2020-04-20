package ch.heigvd.gen.monopoly.board;

/**
 * Classe Square that represents the square in a Monopoly Board
 * @author Müller Robin, Teixeira Carvalho Stéphane
 */
public class Square {
    private String name;

    /**
     * Specific constructor of the class Square.
     * Permits to define a name for the square
     * @param name String that will be the name of the square
     */
    public Square(String name){
        this.name = name;
    }

    /**
     * Getter that returns the name of the square
     * @return String that is the name of the square
     */
    public String getName(){
        return name;
    }
}
