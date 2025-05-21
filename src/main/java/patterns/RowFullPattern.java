package patterns;

import boardfactory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import strategy.Direction;
import strategy.DirectionStrategy;

import java.util.Optional;

public class RowFullPattern extends Row implements Pattern {
    private final Direction direction;

    public RowFullPattern(Direction direction, int length) {
        this.direction = direction;
        this.length = length;
    }


    @Override
    public boolean matches(Board board, DirectionStrategy strategy, Position pos, Mark mark) {
        if (mark == null){
            mark = board.get(pos.col(), pos.row());
        }
        if (mark == Mark.NULL){
            return false;
        }
        Position newPosition = pos;
        for (int i = 0; i < length; i++) {
            if (board.get(newPosition.col(), newPosition.row()) != mark) {
                return false;
            }
            Optional<Position> nextPosition = strategy.next(newPosition, direction);
            if (nextPosition.isPresent()) {
                newPosition = nextPosition.get();
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public Move getFoundMove() {
        return null;
    }
}