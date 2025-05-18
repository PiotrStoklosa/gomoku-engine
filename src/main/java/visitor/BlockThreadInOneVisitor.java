package visitor;

import composite.ThreatInOneMoveGroup;
import factory.Board;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;

public class BlockThreadInOneVisitor extends CheckVisitorTemplate {


    @Override
    protected void scanForPatterns(Board board) throws TheWinnerIsException, ResignException, WrongBoardStateException {
        pattern = new ThreatInOneMoveGroup();
        nextMove = board.getOpponentMove();
        super.scanForPatterns(board);
        if (move != null) {
            move = new Move(move.position(), board.getNextMove());
        }
    }

}
