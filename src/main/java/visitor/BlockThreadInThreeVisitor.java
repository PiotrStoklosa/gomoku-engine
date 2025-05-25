package visitor;

import boardfactory.Board;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;
import patterns.group.ThreeMovesGroup;

public class BlockThreadInThreeVisitor extends CheckVisitorTemplate{
    @Override
    protected void scanForPatterns(Board board) throws TheWinnerIsException, ResignException, WrongBoardStateException {
        pattern = new ThreeMovesGroup();
        nextMove = board.getOpponentMove();
        super.scanForPatterns(board);
        if (move != null) {
            move = new Move(move.position(), board.getNextMove());
        }
    }
}
