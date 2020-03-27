package ch.heigvd.gen.monopoly.pieces;

public class Die {
    private final static int NB_FACES = 6;
    private int faceValue;

    public Die(){
        faceValue = 1;
    }

    public void roll(){
        faceValue =  1 + (int)(Math.random() * NB_FACES);
    }

    public int getFaceValue(){
        return faceValue;
    }
}
