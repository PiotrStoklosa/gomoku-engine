package visitor;


import boardfactory.FixedBoard;
import boardfactory.PeriodicBoundaryBoard;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;

import java.util.Optional;

public interface BoardVisitor {
    Optional<Move> visit(PeriodicBoundaryBoard board) throws TheWinnerIsException, ResignException, WrongBoardStateException;

    Optional<Move> visit(FixedBoard board) throws TheWinnerIsException, ResignException, WrongBoardStateException;
}
