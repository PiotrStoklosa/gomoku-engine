package factory;

import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;
import visitor.BoardVisitor;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

public abstract class Board {

    public abstract boolean getPeriodicBoundaryConditionsInUse();

    public abstract Optional<Move> accept(BoardVisitor visitor) throws TheWinnerIsException, ResignException, WrongBoardStateException;

    private final int size;
    private final Mark[][] cells;
    private final Mark nextMove;
    private final Mark firstMark;


    public Board(Set<Move> boardState, int size, Mark nextMove, Mark firstMark) throws WrongBoardStateException {
        this.size = size;
        this.nextMove = nextMove;
        this.cells = new Mark[size][size];
        this.firstMark = firstMark;

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                cells[i][j] = Mark.NULL;

        for (Move move : boardState) {
            int col = move.position().col();
            int row = move.position().row();
            if (col >= 0 && col < size && row >= 0 && row < size) {
                cells[col][row] = move.mark();
            } else {
                throw new WrongBoardStateException();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Mark get(int c, int r) {
        return cells[c][r];
    }

    public void set(int c, int r, Mark m) {
        cells[c][r] = m;
    }

    public Memento createMemento() {
        Mark[][] copy = new Mark[size][size];
        for (int i = 0; i < size; i++) {
            copy[i] = Arrays.copyOf(cells[i], size);
        }
        return new Memento(copy);
    }

    public void restore(Memento m) {
        for (int i = 0; i < size; i++) {
            System.arraycopy(m.state[i], 0, this.cells[i], 0, size);
        }
    }

    public Mark getNextMove() {
        return nextMove;
    }

    public Mark getOpponentMove() {
        if (nextMove == Mark.CROSS) {
            return Mark.NOUGHT;
        }
        return Mark.CROSS;
    }

    public Mark getFirstMark() {
        return firstMark;
    }

    public static class Memento {
        private final Mark[][] state;

        private Memento(Mark[][] state) {
            this.state = state;
        }
    }

}
