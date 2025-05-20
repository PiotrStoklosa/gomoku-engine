package factory;

import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;
import visitor.BoardVisitor;

import java.util.Optional;
import java.util.Set;

public class PeriodicBoundaryBoard extends Board {
    public PeriodicBoundaryBoard(Set<Move> boardState, int size, Mark nextMove, Mark firstMark) throws WrongBoardStateException {
        super(boardState, size, nextMove, firstMark);
    }

    @Override
    public boolean getPeriodicBoundaryConditionsInUse() {
        return true;
    }

    @Override
    public Optional<Move> accept(BoardVisitor visitor) throws TheWinnerIsException, ResignException, WrongBoardStateException {
        return visitor.visit(this);
    }
}
