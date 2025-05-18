package strategy;

import fais.zti.oramus.gomoku.Position;

import java.util.Optional;

public class PeriodicDirectionStrategy implements DirectionStrategy {
    private final int size;

    public PeriodicDirectionStrategy(int size) {
        this.size = size;
    }

    @Override
    public Optional<Position> next(Position pos, Direction dir) {
        int col = pos.col();
        int row = pos.row();

        return switch (dir) {
            case UP -> Optional.of(new Position(col, (row - 1 + size) % size));
            case DOWN -> Optional.of(new Position(col, (row + 1) % size));
            case LEFT -> Optional.of(new Position((col - 1 + size) % size, row));
            case RIGHT -> Optional.of(new Position((col + 1) % size, row));
            case UP_LEFT -> Optional.of(new Position((col - 1 + size) % size, (row - 1 + size) % size));
            case UP_RIGHT -> Optional.of(new Position((col + 1) % size, (row - 1 + size) % size));
            case DOWN_LEFT -> Optional.of(new Position((col - 1 + size) % size, (row + 1) % size));
            case DOWN_RIGHT -> Optional.of(new Position((col + 1) % size, (row + 1) % size));
        };
    }
}
