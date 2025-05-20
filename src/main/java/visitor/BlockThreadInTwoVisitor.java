package visitor;

import composite.group.ThreatInTwoMovesGroup;
import factory.Board;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;

public class BlockThreadInTwoVisitor extends CheckVisitorTemplate {


    @Override
    protected void scanForPatterns(Board board) throws TheWinnerIsException, ResignException, WrongBoardStateException {
        pattern = new ThreatInTwoMovesGroup();
        nextMove = board.getOpponentMove();
        super.scanForPatterns(board);
        if (move != null) {
            move = new Move(move.position(), board.getNextMove());
        }
    }
}
