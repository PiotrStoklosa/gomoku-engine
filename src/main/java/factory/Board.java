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


    public Board(Set<Move> boardState, int size, Mark nextMove) throws WrongBoardStateException {
        this.size = size;
        this.nextMove = nextMove;
        this.cells = new Mark[size][size];

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

        System.out.print("   ");
        for (int col = 0; col < size; col++) {
            System.out.printf("%2d ", col);
        }
        System.out.println();
        for (int row = 0; row < size; row++) {
            System.out.printf("%2d ", row);
            for (int col = 0; col < size; col++) {
                System.out.print(" " + cells[col][row] + " ");
            }
            System.out.println();
        }

    }

    public int getSize() { return size; }
    public Mark get(int r, int c) { return cells[r][c]; }
    public void set(int r, int c, Mark m) { cells[r][c] = m; }

    /** Tworzy memento (głęboką kopię stanu planszy) */
    public Memento createMemento() {
        Mark[][] copy = new Mark[size][size];
        for (int i = 0; i < size; i++) {
            copy[i] = Arrays.copyOf(cells[i], size);
        }
        return new Memento(size, copy);
    }

    /** Przywraca stan z mementa */
    public void restore(Memento m) {
        if (m.size != this.size)
            throw new IllegalArgumentException("Niezgodny rozmiar");
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

    /** Klasa pamiątki */
    public static class Memento {
        private final int size;
        private final Mark[][] state;
        private Memento(int size, Mark[][] state) {
            this.size = size;
            this.state = state;
        }
    }

}
