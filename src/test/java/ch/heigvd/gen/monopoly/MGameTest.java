package ch.heigvd.gen.monopoly;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MGameTest {
    @Test
    public void testGameRun() {
        MGame mgame = new MGame(4);
        mgame.playGame();
    }
}
