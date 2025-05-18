package visitor;

import composite.Pattern;
import factory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Position;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;
import template.TemplateVisitor;

import java.util.Optional;

public abstract class CheckVisitorTemplate extends TemplateVisitor {

    protected Pattern pattern;
    Mark nextMove = null;

    @Override
    protected void scanForPatterns(Board board) throws TheWinnerIsException, ResignException, WrongBoardStateException {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (pattern.matches(board, strategy, new Position(i, j), Optional.of(nextMove))) {
                    move = pattern.getFoundMove();
                    return;
                }
            }
        }
    }

    @Override
    protected Mark findMark() {
        return nextMove;
    }
}
