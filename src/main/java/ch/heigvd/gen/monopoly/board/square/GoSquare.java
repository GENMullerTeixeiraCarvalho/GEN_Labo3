package ch.heigvd.gen.monopoly.board.square;

import ch.heigvd.gen.monopoly.Player;

public class GoSquare extends Square {
    private static final int CASH_INCOME = 200;

    public GoSquare() {
        super("Go");
    }

    @Override
    public void landedOn(Player p) {
        p.addCash(CASH_INCOME);
    }
}
