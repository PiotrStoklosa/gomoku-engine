import factory.Board;
import factory.BoardFactory;
import fais.zti.oramus.gomoku.Game;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;
import visitor.BlockThreadInOneVisitor;
import visitor.BlockThreadInTwoVisitor;
import visitor.BoardVisitor;
import visitor.CheckStateVisitor;
import visitor.OpponentWinInOneVisitor;
import visitor.OpponentWinInTwoVisitor;
import visitor.WinCheckInOneVisitor;
import visitor.WinCheckInThreeVisitor;
import visitor.WinCheckInTwoVisitor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Gomoku implements Game {

    boolean periodicBoundaryConditionsInUse = false;
    int size;
    private final List<BoardVisitor> boardVisitorList;


    @Override
    public void firstMark(Mark first) {

    }

    @Override
    public void size(int size) {
        this.size = size;
    }

    @Override
    public void periodicBoundaryConditionsInUse() {
        periodicBoundaryConditionsInUse = true;
    }

    @Override
    public Move nextMove(Set<Move> boardState, Mark nextMoveMark) throws ResignException, TheWinnerIsException, WrongBoardStateException {


        Board board = BoardFactory.createBoard(periodicBoundaryConditionsInUse).create(boardState, size, nextMoveMark);

        for (BoardVisitor visitor : boardVisitorList) {

            Board.Memento m = board.createMemento();

            Optional<Move> move = board.accept(visitor);
            if (move.isPresent()) {
                return move.get();
            }
            board.restore(m);
        }
        throw new ResignException();
    }

    public Gomoku() {

        boardVisitorList = Arrays.asList(
                new CheckStateVisitor(), // done
                new WinCheckInOneVisitor(), // done
                new OpponentWinInOneVisitor(),
                new BlockThreadInOneVisitor(), // done
                new WinCheckInTwoVisitor(), // done
                new OpponentWinInTwoVisitor(), // done
                new BlockThreadInTwoVisitor(), // done
                new WinCheckInThreeVisitor()
        );

    }
}