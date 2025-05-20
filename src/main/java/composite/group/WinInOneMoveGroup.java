package composite.group;

import composite.OpenFieldsAtEndsRowPattern;
import composite.Pattern;
import composite.RowWithEmptyFieldsPattern;
import factory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import strategy.Direction;
import strategy.DirectionStrategy;

import java.util.Optional;

public class WinInOneMoveGroup extends PatternGroup {

    private Move foundMove;

    public WinInOneMoveGroup() {
        for (Direction direction : Direction.values()) {
            patterns.add(new OpenFieldsAtEndsRowPattern(direction, 4, 2, true));
        }
        for (Direction direction : Direction.values()) {
            patterns.add(new OpenFieldsAtEndsRowPattern(direction, 4, 1, true));
        }
        for (Direction direction : Direction.values()) {
            patterns.add(new RowWithEmptyFieldsPattern(direction, 5));
        }

    }

    @Override
    public boolean matches(Board board, DirectionStrategy strategy, Position pos, Optional<Mark> mark) {
        for (Pattern pattern : patterns) {
            if (pattern.matches(board, strategy, pos, mark)) {
                foundMove = pattern.getFoundMove();
                return true;
            }
        }
        return false;
    }

    @Override
    public Move getFoundMove() {
        return foundMove;
    }
}
