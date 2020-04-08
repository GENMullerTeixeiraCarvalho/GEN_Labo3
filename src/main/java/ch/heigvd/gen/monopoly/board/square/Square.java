package ch.heigvd.gen.monopoly.board.square;

import ch.heigvd.gen.monopoly.Player;

public abstract class Square {
    private String name;

    public Square(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public abstract void landedOn(Player p);
}