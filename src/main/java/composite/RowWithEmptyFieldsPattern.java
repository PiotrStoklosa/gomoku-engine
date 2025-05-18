package composite;

import factory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import strategy.Direction;
import strategy.DirectionStrategy;

import java.util.Optional;

public class RowWithEmptyFieldsPattern extends Row implements Pattern{

    Move foundMove;
    private final Direction direction;

    public RowWithEmptyFieldsPattern(Direction direction, int length) {
        this.direction = direction;
        this.length = length;
    }
    @Override
    public boolean matches(Board board, DirectionStrategy strategy, Position pos, Optional<Mark> mark) {
        Mark m = mark.orElse(board.get(pos.col(), pos.row()));

        Position current = pos;
        int mismatches = 0;
        Optional<Position> next = Optional.of(current);
        for (int i = 0; i < length; i++) {
            if (next.isPresent()) {
                current = next.get();
            } else {
                return false;
            }
            Mark currentMark = board.get(current.col(), current.row());
            if (currentMark != m) {
                if (currentMark != Mark.NULL || i == 0 || i + 1 == length) {
                    return false;
                }
                mismatches++;
                foundMove = new Move(current,m);
            }

            if (mismatches > 1) {
                return false;
            }

          next = strategy.next(current, direction);

        }

        return mismatches == 1;
    }

    @Override
    public Move getFoundMove() {
        return foundMove;
    }
}
