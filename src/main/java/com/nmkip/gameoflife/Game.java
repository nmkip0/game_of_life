package com.nmkip.gameoflife;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static java.util.Arrays.asList;

public class Game {

    private Set<Coordinate> livingCells;
    private Board board;

    public Game(Coordinate... livingCells) {
        this.livingCells = new HashSet<>(asList(livingCells));
        this.board = new Board(livingCells);
    }

    private Game(Set<Coordinate> newBoard) {
        this.livingCells = newBoard;
    }

    Game tick() {
        Set<Coordinate> newBoard = new HashSet<>();
        for (Coordinate aliveCell : livingCells) {
            if(board.aliveNeighboursAround(aliveCell) > 3) {

            } else if(board.aliveNeighboursAround(aliveCell) > 2){
                newBoard.add(aliveCell);
            }
        }
        return new Game(newBoard);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return livingCells.equals(game.livingCells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livingCells);
    }

    @Override
    public String toString() {
        return livingCells.toString();
    }
}
