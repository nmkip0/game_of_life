package com.nmkip.gameoflife;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class GameShould {

    @Test
    void create_seed() {
        Game game = new Game(Cell.at(new Coordinates(3,3)));

        assertThat(game, is(new Game(Cell.at(new Coordinates(3, 3)))));
    }
}
