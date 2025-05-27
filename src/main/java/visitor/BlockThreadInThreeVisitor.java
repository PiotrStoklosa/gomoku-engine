package visitor;

import boardfactory.Board;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;
import patterns.group.ThreeMovesGroup;

public class BlockThreadInThreeVisitor extends BlockThreatVisitorTemplate {
    @Override
    protected void scanForPatterns(Board board) throws TheWinnerIsException, ResignException, WrongBoardStateException {
        Board.Memento m = board.createMemento();
        pattern = new ThreeMovesGroup();
        nextMove = board.getOpponentMove();
        super.scanForPatterns(board);
        if (move != null) {
            Move blockMove = new Move(move.position(), board.getNextMove());
            board.set(move.position().col(), move.position().row(), board.getNextMove());

            setPatternChain(new ThreeMovesGroup());

            scanForPatternChain(board);

            board.restore(m);
            move = blockMove;
        }
    }
}
