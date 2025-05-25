package patterns.group;

import patterns.CrossThreatPattern;
import patterns.OpenFieldsAtEndsRowPattern;
import patterns.Pattern;
import boardfactory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import strategy.Direction;
import strategy.DirectionStrategy;

public class NotBlockingWinInTwoMoveGroup extends PatternGroup {
    private Move foundMove;

    public NotBlockingWinInTwoMoveGroup() {
        patterns.add(new CrossThreatPattern(Direction.UP));
        patterns.add(new CrossThreatPattern(Direction.RIGHT));
        patterns.add(new CrossThreatPattern(Direction.UP_RIGHT));
        patterns.add(new CrossThreatPattern(Direction.DOWN_RIGHT));
        for (Direction direction : Direction.values()) {
            patterns.add(new OpenFieldsAtEndsRowPattern(direction, 3, 3, true));
        }
    }

    @Override
    public boolean matches(Board board, DirectionStrategy strategy, Position pos, Mark mark) {
        boolean patternAlreadyFound = false;
        for (Pattern pattern : patterns) {
            if (pattern.matches(board, strategy, pos, mark)) {
                if (patternAlreadyFound) {
                    foundMove = new Move(pos, mark);
                    return true;
                }
                patternAlreadyFound = true;
            }
        }
        return false;
    }

    @Override
    public Move getFoundMove() {
        return foundMove;
    }
}
