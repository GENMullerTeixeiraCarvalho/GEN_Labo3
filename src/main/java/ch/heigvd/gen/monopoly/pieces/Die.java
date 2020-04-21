package ch.heigvd.gen.monopoly.pieces;

/**
 * Die Class that permit us to roll a die and get his value
 * @author Müller Robin, Teixeira Carvalho Stéphane
 */
public class Die {
    private final static int NB_FACES = 6;
    private int faceValue;

    /**
     * Constructor by default of the Die Class
     */
    public Die(){
        //Assign the value 1 to faceValue because 0 is impossible for a die
        faceValue = 1;
    }

    /**
     * Roll the die and store the value in the faceValue variable
     */
    public void roll(){
        //Will give a number between 1 and 6
        faceValue =  1 + (int)(Math.random() * NB_FACES);
    }

    /**
     * Get the value of the variable faceValue
     * @return an int that is the value of faceValue
     */
    public int getFaceValue(){
        return faceValue;
    }
}
