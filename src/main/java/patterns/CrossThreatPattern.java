package patterns;

import boardfactory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import strategy.Direction;
import strategy.DirectionStrategy;

import java.util.Optional;

public class CrossThreatPattern implements Pattern {

    private final Direction direction;
    private Move foundMove;

    public CrossThreatPattern(Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean matches(Board board, DirectionStrategy strategy, Position pos, Mark mark) {
        if (!mark.equals(board.get(pos.col(), pos.row()))){
            return false;
        }
        Optional<Position> pos1 = strategy.next(pos, direction);
        Optional<Position> pos2 = strategy.next(pos, direction.opposite());
        if (pos1.isEmpty() || pos2.isEmpty()) {
            return false;
        }
        Position p1 = pos1.get();
        Position p2 = pos2.get();
        if (!board.get(p1.col(), p1.row()).equals(mark) || !board.get(p2.col(), p2.row()).equals(mark)) {
            return false;
        }

        pos1 = strategy.next(p1, direction);
        pos2 = strategy.next(p2, direction.opposite());
        if (pos1.isEmpty() || pos2.isEmpty()) {
            return false;
        }
        p1 = pos1.get();
        p2 = pos2.get();
        if (!board.get(p1.col(), p1.row()).equals(Mark.NULL) || !board.get(p2.col(), p2.row()).equals(Mark.NULL)) {
            return false;
        }

        pos1 = strategy.next(p1, direction);
        pos2 = strategy.next(p2, direction.opposite());
        if (pos1.isPresent() && board.get(pos1.get().col(), pos1.get().row()).equals(Mark.NULL)
                || pos2.isPresent() && board.get(pos2.get().col(), pos2.get().row()).equals(Mark.NULL)) {
            foundMove = new Move(pos, mark);
            return true;
        }
        return false;
    }

    @Override
    public Move getFoundMove() {
        return foundMove;
    }
}
