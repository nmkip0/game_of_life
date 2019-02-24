package com.nmkip.gameoflife;

import java.util.Arrays;

public class Game {

    private Cell[] livingCells;

    public Game(Cell... livingCells) {
        this.livingCells = livingCells;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Arrays.equals(livingCells, game.livingCells);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(livingCells);
    }

    @Override
    public String toString() {
        return "Living cells: " + Arrays.toString(livingCells);
    }
}
