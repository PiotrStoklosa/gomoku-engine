package composite;

import factory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import strategy.Direction;
import strategy.DirectionStrategy;

import java.util.Optional;

public class OpenFieldsAtEndsRowPattern implements Pattern {
    private final RowPattern rowPattern;
    private final Direction direction;
    private final int nulls;
    private Move foundMove;

    public OpenFieldsAtEndsRowPattern(Direction direction, int length, int nulls) {
        this.direction = direction;
        this.rowPattern = new RowPattern(direction, length);
        this.nulls = nulls;
    }

    @Override
    public boolean matches(Board board, DirectionStrategy strategy, Position pos, Optional<Mark> mark) {

        if (!rowPattern.matches(board, strategy, pos, mark)) {
            return false;
        }
        int begin = 0;
        Position beginPosition = null;
        int end = 0;
        Position endPosition = null;

        Mark m = mark.orElse(board.get(pos.col(), pos.row()));
        Optional<Position> beforeStart;
        for (int i = 0; i < 2; i++) {
            beforeStart = strategy.next(pos, direction.opposite());
            if (beforeStart.isPresent()) {
                Position p = beforeStart.get();
                if (board.get(p.col(), p.row()) == Mark.NULL) {
                    if (beginPosition == null) {
                        beginPosition = p;
                    }
                    begin++;
                } else{
                    break;
                }
            } else {
                break;
            }
        }

        Position current = pos;
        for (int i = 1; i < rowPattern.length; i++) {
            Optional<Position> next = strategy.next(current, direction);
            if (next.isEmpty()) return false;
            current = next.get();
        }

        Optional<Position> afterEnd;
        for (int i = 0; i < 2; i++) {
            afterEnd = strategy.next(current, direction);
            if (afterEnd.isPresent()) {
                Position p = afterEnd.get();
                if (board.get(p.col(), p.row()) == Mark.NULL) {
                    if (endPosition == null) {
                        endPosition = p;
                    }
                    end++;
                }
            } else {
                break;
            }
        }

        if (nulls == 3) {
            if (begin == 2) {
                foundMove = new Move(beginPosition, m);
                return true;
            } else if (end == 2) {
                foundMove = new Move(endPosition, m);
                return true;
            }
            return false;
        }
        if (nulls == 2) {
            if (begin > 0 && end > 0) {
                foundMove = new Move(beginPosition, m);
                return true;
            }
            return false;
        }
        if (begin > 0 && end == 0) {
            foundMove = new Move(beginPosition, m);
            return true;
        }
        if (end > 0 && begin == 0) {
            foundMove = new Move(endPosition, m);
            return true;
        }
        return false;
    }

    @Override
    public Move getFoundMove() {
        return foundMove;
    }
}
