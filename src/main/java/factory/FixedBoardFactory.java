package factory;

import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.WrongBoardStateException;

import java.util.Set;

public class FixedBoardFactory extends BoardFactory {

    @Override
    public Board create(Set<Move> boardState, int size, Mark nextMove) throws WrongBoardStateException {
        return new FixedBoard( boardState, size, nextMove);
    }
}
