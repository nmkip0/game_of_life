package com.nmkip.gameoflife;

import java.util.Objects;

class Cell {

    private final Coordinates coordinates;

    Cell(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    static Cell at(Coordinates coordinates) {
        return new Cell(coordinates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(coordinates, cell.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }

    @Override
    public String toString() {
        return coordinates.toString();
    }
}
