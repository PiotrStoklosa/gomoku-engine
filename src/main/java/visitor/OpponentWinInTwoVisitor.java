package visitor;

import composite.group.NotBlockingWinInTwoMoveGroup;
import factory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;

public class OpponentWinInTwoVisitor extends CheckVisitorTemplate {
    private Mark nextMark;

    @Override
    protected void scanForPatterns(Board board) throws TheWinnerIsException, WrongBoardStateException, ResignException {
        pattern = new NotBlockingWinInTwoMoveGroup();
        nextMove = board.getOpponentMove();
        super.scanForPatterns(board);
        if (move != null) {
            throw new ResignException();
        }
    }

    @Override
    protected Mark findMark() {
        return nextMark;
    }
}
