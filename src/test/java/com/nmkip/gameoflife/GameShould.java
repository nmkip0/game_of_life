package com.nmkip.gameoflife;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class GameShould {

    @Test
    void create_seed() {
        Game game = new Game(new Coordinate(3, 3));

        assertThat(game, is(new Game(new Coordinate(3, 3))));
    }

    @Test
    void kill_a_cell_that_had_no_neighbours_after_tick() {
        Game game = new Game(new Coordinate(3,3));

        game = game.tick();

        assertThat(game, is(new Game()));
    }

    @Test
    @Disabled
    void preserve_a_block_after_tick() {
        Game game = new Game(aBlock());

        game = game.tick();

        assertThat(game, is(new Game(aBlock())));
    }

    private Coordinate[] aBlock() {
        return new Coordinate[] {
                new Coordinate(3,3), new Coordinate(3,4),
                new Coordinate(4,3), new Coordinate(4,4)
        };
    }
}
