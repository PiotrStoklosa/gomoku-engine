package visitor;

import boardfactory.Board;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;
import patterns.group.ThreatInTwoMovesGroup;
import patterns.group.ThreeMovesGroup;

public class BlockThreadInTwoVisitor extends BlockThreatVisitorTemplate {


    @Override
    protected void scanForPatterns(Board board) throws TheWinnerIsException, ResignException, WrongBoardStateException {
        Board.Memento m = board.createMemento();
        pattern = new ThreatInTwoMovesGroup();
        nextMove = board.getOpponentMove();
        super.scanForPatterns(board);
        if (move != null) {
            Move blockMove = new Move(move.position(), board.getNextMove());
            board.set(move.position().col(), move.position().row(), board.getNextMove());

            setPatternChain(new ThreatInTwoMovesGroup());
            setPatternChain(new ThreeMovesGroup());

            scanForPatternChain(board);

            board.restore(m);
            move = blockMove;
        }
    }
}
