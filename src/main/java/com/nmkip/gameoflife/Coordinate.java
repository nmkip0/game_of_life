package com.nmkip.gameoflife;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Coordinate {
    private final int x;
    private final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Set<Coordinate> neighbours() {
        Set<Coordinate> neighbours = new HashSet<>();
        neighbours.add(new Coordinate(x - 1, y));
        neighbours.add(new Coordinate(x + 1, y));
        neighbours.add(new Coordinate(x + 1, y));
        neighbours.add(new Coordinate(x, y - 1));
        neighbours.add(new Coordinate(x, y + 1));
        neighbours.add(new Coordinate(x - 1, y - 1));
        neighbours.add(new Coordinate(x - 1, y + 1));
        neighbours.add(new Coordinate(x + 1, y - 1));
        neighbours.add(new Coordinate(x + 1, y + 1));
        return neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}
