package visitor;

import patterns.Pattern;
import boardfactory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Position;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;
import template.TemplateVisitor;


public abstract class CheckVisitorTemplate extends TemplateVisitor {

    protected Pattern pattern;
    protected Mark nextMove;

    @Override
    protected void scanForPatterns(Board board) throws TheWinnerIsException, ResignException, WrongBoardStateException {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (pattern.matches(board, strategy, new Position(i, j), nextMove)) {
                    move = pattern.getFoundMove();
                    return;
                }
            }
        }
    }
}
