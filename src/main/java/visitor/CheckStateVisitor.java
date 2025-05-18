package visitor;


import composite.IllegalStateGroup;
import composite.Pattern;
import composite.RowFullPattern;
import factory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Position;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;
import strategy.Direction;
import strategy.DirectionStrategy;
import template.TemplateVisitor;

import java.util.Optional;

public class CheckStateVisitor extends TemplateVisitor {

    Pattern invalidState = new IllegalStateGroup();

    private Mark clearWin(Board board, DirectionStrategy strategy, Position pos) {
        for (Direction direction : Direction.values()) {
            if (new RowFullPattern(direction, 5).matches(board, strategy, pos, Optional.empty())) {
                Mark mark = board.get(pos.col(), pos.row());
                Position newPosition = pos;
                for (int i = 0; i < 5; i++) {
                    board.set(newPosition.col(), newPosition.row(), Mark.NULL);
                    newPosition = strategy.next(newPosition, direction).get();
                }
                return mark;
            }
        }
        throw new RuntimeException("Didn't find any winning pattern");
    }

    private boolean validBoard(Board board, Mark nextMoveMark) {

        int x = 0;
        int o = 0;

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.get(i, j) == Mark.CROSS) {
                    x++;
                } else if (board.get(i, j) == Mark.NOUGHT) {
                    o++;
                }
            }
        }

        if (nextMoveMark == Mark.NOUGHT) {
            return o - x == 0 || o - x == -1;
        } else {
            return x - o == 0 || x - o == -1;
        }
    }

    @Override
    protected void scanForPatterns(Board board) throws WrongBoardStateException, TheWinnerIsException {

        if (!validBoard(board, board.getNextMove())) {
            throw new WrongBoardStateException();
        }

        Optional<Mark> alreadyWin = Optional.empty();
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (invalidState.matches(board, strategy, new Position(i, j), Optional.empty())) {
                    if (alreadyWin.isPresent()) {
                        throw new WrongBoardStateException();
                    }
                    alreadyWin = Optional.ofNullable(clearWin(board, strategy, new Position(i, j)));
                }
            }
        }
        if (alreadyWin.isPresent()) {
            throw new TheWinnerIsException(alreadyWin.get());
        }
    }

    @Override
    protected Mark findMark() {
        return null;
    }

}
