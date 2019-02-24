package com.nmkip.gameoflife;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class GameShould {

    @Test
    void initialise_system() {
        Game game = new Game(Cell.at(0, 0), Cell.at(0, 1));

        assertThat(game, is(new Game(Cell.at(0, 0), Cell.at(0, 1))));
    }

}
