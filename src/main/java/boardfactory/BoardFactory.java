package boardfactory;

import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.WrongBoardStateException;

import java.util.Set;

public abstract class BoardFactory {

    public abstract Board create(Set<Move> boardState, int size, Mark nextMove, Mark firstMark) throws WrongBoardStateException;

    public static BoardFactory createBoard(boolean curve){
        if (curve){
            return new PeriodicBoundaryBoardFactory();
        }
        else {
            return new FixedBoardFactory();
        }
    }

}
