package ch.heigvd.gen.monopoly.board.square;

import ch.heigvd.gen.monopoly.Player;

public class GoToJailSquare extends Square {
    private Square jail;
    public GoToJailSquare(Square jail) {
        super("GoToJail");
        this.jail = jail;
    }

    @Override
    public void landedOn(Player p) {
        p.setLocation(jail);
    }
}
