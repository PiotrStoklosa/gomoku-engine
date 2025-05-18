package composite;

import factory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import strategy.Direction;
import strategy.DirectionStrategy;

import java.util.Optional;

public class ThreatInTwoMovesGroup extends PatternGroup{

    public ThreatInTwoMovesGroup() {
        patterns.add(new RowPattern(Direction.RIGHT, 3));
        patterns.add(new RowPattern(Direction.UP, 3));
        patterns.add(new RowPattern(Direction.UP_RIGHT, 3));
        patterns.add(new RowPattern(Direction.UP_LEFT, 3));
    }

    @Override
    public boolean matches(Board board, DirectionStrategy strategy, Position pos, Optional<Mark> mark) {
        return false;
    }

    @Override
    public Move getFoundMove() {
        return null;
    }
}
