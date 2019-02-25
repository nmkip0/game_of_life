package com.nmkip.gameoflife;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Board {

    private final Set<Coordinate> livingCells;

    Board(Coordinate[] livingCells) {
        this.livingCells = new HashSet<>(Arrays.asList(livingCells));
    }

    long aliveNeighboursAround(Coordinate cell) {
        return cell.getNeighbours().stream()
                            .filter(livingCells::contains)
                            .count();
    }

}
