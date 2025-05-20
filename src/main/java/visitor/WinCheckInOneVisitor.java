package visitor;

import composite.group.WinInOneMoveGroup;
import factory.Board;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;


public class WinCheckInOneVisitor extends CheckVisitorTemplate {

    @Override
    protected void scanForPatterns(Board board) throws WrongBoardStateException, TheWinnerIsException, ResignException {
        pattern = new WinInOneMoveGroup();
        nextMove = board.getNextMove();
        super.scanForPatterns(board);
    }


}
