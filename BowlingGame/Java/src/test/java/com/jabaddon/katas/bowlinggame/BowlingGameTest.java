package com.jabaddon.katas.bowlinggame;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class BowlingGameTest {
    @Test
    public void gutterGame() {
        Game game = new Game();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertThat(game.score(), is(0));
    }
}