package ch.heigvd.gen.monopoly.pieces;

public class Cup {
    private Die[] dice;

    public Cup(int nbDie){
        if(nbDie <= 0){
            throw new IllegalArgumentException("The number of die cannot be egal or under 0");
        }
        this.dice = new Die[nbDie];
        for(int i = 0; i < nbDie; i++){
            dice[i] = new Die();
        }
    }

    public void roll(){
        for(int i = 0; i < dice.length; i++){
            dice[i].roll();
        }
    }

    public int getTotal(){
        int fvTot = 0;
        for(int i = 0; i < dice.length; i++){
            fvTot = dice[i].getFaceValue();
        }
        return fvTot;
    }
}
