package strategy;

import fais.zti.oramus.gomoku.Position;

import java.util.Optional;

public interface DirectionStrategy {
    Optional<Position> next(Position pos, Direction direction);
}
