package ch.heigvd.gen.monopoly;

import org.junit.jupiter.api.Test;

public class MGameTest {
    @Test
    public void testGameRun() {
        MGame mgame = new MGame(4);
        mgame.playGame();
    }
}
