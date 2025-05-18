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
import visitor.OpponentWinInOneVisitor;
import visitor.BoardVisitor;
import visitor.CheckStateVisitor;
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
        }
        return null;
    }

    public Gomoku() {

        // czy my mamy wygraną w 1
        // czy możemy zablokować wygraną przeciwnika w 1
        // czy możemy wygrać w 2 posunięciach
        // czy przeciwnik może wygrać w 2 posunięciach
        // czy możemy wygrać w 3 posunięciach
        // template

        boardVisitorList = Arrays.asList(
                new CheckStateVisitor(), // done
                new WinCheckInOneVisitor(), // done
                new BlockThreadInOneVisitor(), // done
                new OpponentWinInOneVisitor(), // done
                new WinCheckInTwoVisitor(),
                new OpponentWinInTwoVisitor(),
                new BlockThreadInTwoVisitor(),
                new WinCheckInThreeVisitor()
        );

    }
}