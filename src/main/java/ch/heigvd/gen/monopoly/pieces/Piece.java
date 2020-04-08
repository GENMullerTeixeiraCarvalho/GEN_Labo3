package ch.heigvd.gen.monopoly.pieces;

import ch.heigvd.gen.monopoly.board.square.Square;

public class Piece {
    private Square location;

    public Piece(Square location) {
        this.location = location;
    }

    public Square getLocation() {
        return location;
    }

    public void setLocation(Square location) {
        this.location = location;
    }
}
