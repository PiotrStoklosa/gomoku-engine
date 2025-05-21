package visitor;

import patterns.group.WinInThreeMoveGroup;
import boardfactory.Board;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;

public class WinCheckInThreeVisitor extends CheckVisitorTemplate {

    @Override
    protected void scanForPatterns(Board board) throws TheWinnerIsException, ResignException, WrongBoardStateException {
        pattern = new WinInThreeMoveGroup();
        nextMove = board.getNextMove();
        super.scanForPatterns(board);
    }
}
