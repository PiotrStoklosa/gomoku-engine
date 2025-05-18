package strategy;

import fais.zti.oramus.gomoku.Position;

import java.util.Optional;

public class FixedDirectionStrategy implements DirectionStrategy {
    private final int size;

    public FixedDirectionStrategy(int size) {
        this.size = size;
    }

    @Override
    public Optional<Position> next(Position pos, Direction dir) {
        int col = pos.col();
        int row = pos.row();

        return switch (dir) {
            case UP -> (row > 0) ? Optional.of(new Position(col, row - 1)) : Optional.empty();
            case DOWN -> (row < size - 1) ? Optional.of(new Position(col, row + 1)) : Optional.empty();
            case LEFT -> (col > 0) ? Optional.of(new Position(col - 1, row)) : Optional.empty();
            case RIGHT -> (col < size - 1) ? Optional.of(new Position(col + 1, row)) : Optional.empty();
            case UP_LEFT -> (col > 0 && row > 0) ? Optional.of(new Position(col - 1, row - 1)) : Optional.empty();
            case UP_RIGHT ->
                    (col < size - 1 && row > 0) ? Optional.of(new Position(col + 1, row - 1)) : Optional.empty();
            case DOWN_LEFT ->
                    (col > 0 && row < size - 1) ? Optional.of(new Position(col - 1, row + 1)) : Optional.empty();
            case DOWN_RIGHT ->
                    (col < size - 1 && row < size - 1) ? Optional.of(new Position(col + 1, row + 1)) : Optional.empty();
        };
    }
}