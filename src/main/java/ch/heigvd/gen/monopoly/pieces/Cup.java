package ch.heigvd.gen.monopoly.pieces;

/**
 * Class Cup that represents a cup of dice in a Monopoly Game
 */
public class Cup {
    private Die[] dice;

    /**
     * Specific constructor of the cup class
     * @param nbDie int being the number of dice for the cup
     * @throws IllegalArgumentException if nbDie is below or equal to 0
     */
    public Cup(int nbDie){
        if(nbDie <= 0){
            throw new IllegalArgumentException("The number of die cannot be egal or under 0");
        }
        this.dice = new Die[nbDie];
        for(int i = 0; i < nbDie; i++){
            dice[i] = new Die();
        }
    }

    /**
     * Roll all the dice in the cup
     */
    public void roll(){
        for(int i = 0; i < dice.length; i++){
            dice[i].roll();
        }
    }

    /**
     * Get the total of all the faceValue of the dice
     * @return int that is the total of all faceValue of the dice in the cup
     */
    public int getTotal(){
        int fvTot = 0;
        for(int i = 0; i < dice.length; i++){
            fvTot = dice[i].getFaceValue();
        }
        return fvTot;
    }
}
