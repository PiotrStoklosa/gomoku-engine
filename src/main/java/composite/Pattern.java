package composite;

import factory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import strategy.DirectionStrategy;

import java.util.Optional;

public interface Pattern {
    Move foundMove = null;
    boolean matches(Board board, DirectionStrategy strategy, Position pos, Optional<Mark> mark);
    Move getFoundMove();
}
