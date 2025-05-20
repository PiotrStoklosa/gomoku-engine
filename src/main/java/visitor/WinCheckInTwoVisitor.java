package visitor;

import composite.group.WinInTwoMoveGroup;
import factory.Board;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;

public class WinCheckInTwoVisitor extends CheckVisitorTemplate {

    @Override
    protected void scanForPatterns(Board board) throws TheWinnerIsException, ResignException, WrongBoardStateException {
        pattern = new WinInTwoMoveGroup();
        nextMove = board.getNextMove();
        super.scanForPatterns(board);
    }

}
