package composite.group;

import composite.Pattern;
import composite.RowFullPattern;
import factory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import strategy.Direction;
import strategy.DirectionStrategy;

import java.util.Optional;

public class IllegalStateGroup extends PatternGroup {

    public IllegalStateGroup() {
        for (Direction direction : Direction.values()) {
            patterns.add(new RowFullPattern(direction, 5));
        }
    }

    @Override
    public boolean matches(Board board, DirectionStrategy strategy, Position pos, Optional<Mark> mark) {
        for (Pattern pattern : patterns) {
            if (pattern.matches(board, strategy, pos, mark)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Move getFoundMove() {
        throw new IllegalCallerException();
    }
}
