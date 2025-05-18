package template;

import factory.Board;
import factory.FixedBoard;
import factory.PeriodicBoundaryBoard;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;
import strategy.DirectionStrategy;
import strategy.FixedDirectionStrategy;
import strategy.PeriodicDirectionStrategy;
import visitor.BoardVisitor;

import java.util.Optional;

public abstract class TemplateVisitor implements BoardVisitor {

    protected DirectionStrategy strategy;
    protected Move move;

    @Override
    public final Optional<Move> visit(PeriodicBoundaryBoard board) throws TheWinnerIsException, ResignException, WrongBoardStateException {
        strategy = new PeriodicDirectionStrategy(board.getSize());
        scanForPatterns(board);
        return createMove();
    }

    @Override
    public final Optional<Move> visit(FixedBoard board) throws TheWinnerIsException, ResignException, WrongBoardStateException {
        strategy = new FixedDirectionStrategy(board.getSize());
        scanForPatterns(board);
        return createMove();
    }

    protected abstract void scanForPatterns(Board board) throws TheWinnerIsException, ResignException, WrongBoardStateException;

    protected Optional<Move> createMove() {
        return Optional.ofNullable(move);
    }

    protected abstract Mark findMark();
}
