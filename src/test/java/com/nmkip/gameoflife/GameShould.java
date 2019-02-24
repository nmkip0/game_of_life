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

    @Test
    void kill_a_cell_that_had_no_neighbours_in_the_previous_generation() {
        Game game = new Game(Cell.at(new Coordinates(3,3)));

        game = game.tick();

        assertThat(game, is(new Game()));
    }
}
