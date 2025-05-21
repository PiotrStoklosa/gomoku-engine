package patterns;

import boardfactory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import strategy.DirectionStrategy;

public interface Pattern {
    boolean matches(Board board, DirectionStrategy strategy, Position pos, Mark mark);
    Move getFoundMove();
}
