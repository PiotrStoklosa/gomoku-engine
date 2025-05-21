package patterns;

import boardfactory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import strategy.Direction;
import strategy.DirectionStrategy;

import java.util.Optional;

public class OpenFieldsAtEndsRowPattern implements Pattern {
    protected final Row rowPattern;
    private final Direction direction;
    private final int nulls;
    private Move foundMove;

    public OpenFieldsAtEndsRowPattern(Direction direction, int length, int nulls, boolean full) {
        this.direction = direction;
        this.nulls = nulls;
        if (full) {
            rowPattern = new RowFullPattern(direction, length);
        } else {
            rowPattern = new RowWithEmptyFieldsPattern(direction, length);
        }
    }

    @Override
    public boolean matches(Board board, DirectionStrategy strategy, Position pos, Mark mark) {

        if (!rowPattern.matches(board, strategy, pos, mark)) {
            return false;
        }
        int begin = 0;
        Position beginPosition = null;
        int end = 0;
        Position endPosition = null;

        Optional<Position> beforeStart = Optional.of(pos);
        for (int i = 0; i < 2; i++) {
            beforeStart = strategy.next(beforeStart.get(), direction.opposite());
            if (beforeStart.isPresent()) {
                Position p = beforeStart.get();
                if (board.get(p.col(), p.row()) == Mark.NULL) {
                    if (beginPosition == null) {
                        beginPosition = p;
                    }
                    begin++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        Position current = pos;
        for (int i = 1; i < rowPattern.getLength(); i++) {
            Optional<Position> next = strategy.next(current, direction);
            if (next.isEmpty()) return false;
            if (board.get(next.get().col(), next.get().row()) == Mark.NULL) {
                foundMove = new Move(next.get(), mark);
            }
            current = next.get();
        }

        Optional<Position> afterEnd = Optional.of(current);
        for (int i = 0; i < 2; i++) {
            afterEnd = strategy.next(afterEnd.get(), direction);
            if (afterEnd.isPresent()) {
                Position p = afterEnd.get();
                if (board.get(p.col(), p.row()) == Mark.NULL) {
                    if (endPosition == null) {
                        endPosition = p;
                    }
                    end++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        if (nulls == 3) {
            if (begin == 2) {
                updateFoundMove(new Move(beginPosition, mark));
                return true;
            } else if (end == 2) {
                updateFoundMove(new Move(endPosition, mark));
                return true;
            }
            return false;
        }
        if (nulls == 2) {
            if (begin > 0 && end > 0) {
                updateFoundMove(new Move(beginPosition, mark));
                return true;
            }
            return false;
        }
        if (begin > 0 && end == 0) {
            updateFoundMove(new Move(beginPosition, mark));
            return true;
        }
        if (end > 0 && begin == 0) {
            updateFoundMove(new Move(endPosition, mark));
            return true;
        }
        return false;
    }

    private void updateFoundMove(Move move) {
        if (rowPattern instanceof RowFullPattern) {
            foundMove = move;
        }
    }

    @Override
    public Move getFoundMove() {
        return foundMove;
    }
}
