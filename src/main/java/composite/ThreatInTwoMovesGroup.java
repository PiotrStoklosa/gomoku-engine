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
        for (Direction direction : Direction.values()) {
            patterns.add(new OpenFieldsAtEndsRowPattern(direction, 3, 2, true));
        }
        for (Direction direction : Direction.values()) {
            patterns.add(new OpenFieldsAtEndsRowPattern(direction, 4, 2, false));
        }
    }

    @Override
    public Move getFoundMove() {
        return foundMove;
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
}
