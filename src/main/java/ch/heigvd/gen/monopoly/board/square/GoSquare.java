package ch.heigvd.gen.monopoly.board.square;

import ch.heigvd.gen.monopoly.Player;

public class GoSquare extends Square {
    public GoSquare() {
        super("Go");
    }

    @Override
    public void landedOn(Player p) {
        p.addCash(200);
    }
}
