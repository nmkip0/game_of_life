package com.nmkip.gameoflife;

import java.util.Objects;

class Cell {
    private final int x;
    private final int y;

    private Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Cell at(int x, int y) {
        return new Cell(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("Cell at (%d,%d)", x, y);
    }
}
