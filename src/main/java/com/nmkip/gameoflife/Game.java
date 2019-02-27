package com.nmkip.gameoflife;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Game {

    private final Set<Coordinate> livingCells;

    public Game(Coordinate... livingCells) {
        this.livingCells = new HashSet<>(asList(livingCells));
    }

    private Game(Set<Coordinate> newBoard) {
        this.livingCells = newBoard;
    }

    Game tick() {
        Set<Coordinate> keptAlive = keepAlive();
        Set<Coordinate> revived = revive();

        keptAlive.addAll(revived);
        return new Game(keptAlive);

    }

    private Set<Coordinate> keepAlive() {
        return livingCells.stream()
                          .filter(this::livingCellWithTwoOrThreeAliveNeighbours)
                          .collect(Collectors.toSet());
    }

    private Set<Coordinate> revive() {
        return livingCells.stream()
                          .map(this::deadNeighboursOf)
                          .flatMap(Collection::stream)
                          .filter(this::deadCellWithExactlyThreeLivingNeighbours)
                          .collect(Collectors.toSet());
    }

    private boolean deadCellWithExactlyThreeLivingNeighbours(Coordinate dead) {
        return aliveNeighboursAround(dead) == 3;
    }

    private boolean livingCellWithTwoOrThreeAliveNeighbours(Coordinate cell) {
        return aliveNeighboursAround(cell) == 2 || aliveNeighboursAround(cell) == 3;
    }

    private Set<Coordinate> deadNeighboursOf(Coordinate aliveCell) {
        return aliveCell.getNeighbours().stream()
                        .filter(n -> !livingCells.contains(n))
                        .collect(Collectors.toSet());
    }

    private long aliveNeighboursAround(Coordinate cell) {
        return cell.getNeighbours().stream()
                   .filter(livingCells::contains)
                   .count();
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
