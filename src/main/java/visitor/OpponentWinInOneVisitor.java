package visitor;

import patterns.group.NotBlockingWinInOneMoveGroup;
import boardfactory.Board;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;

public class OpponentWinInOneVisitor extends CheckVisitorTemplate {

    @Override
    protected void scanForPatterns(Board board) throws TheWinnerIsException, WrongBoardStateException, ResignException {
        pattern = new NotBlockingWinInOneMoveGroup();
        nextMove = board.getOpponentMove();
        super.scanForPatterns(board);
        if (move != null) {
            throw new ResignException();
        }
    }

}
