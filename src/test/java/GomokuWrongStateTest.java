import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import fais.zti.oramus.gomoku.WrongBoardStateException;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GomokuWrongStateTest {

    static Set<Move> createBoardState1() {
        Set<Move> board = new HashSet<>();

        // 15 CROSS
        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(1, 0), Mark.CROSS));
        board.add(new Move(new Position(2, 0), Mark.CROSS));
        board.add(new Move(new Position(3, 0), Mark.CROSS));
        board.add(new Move(new Position(6, 0), Mark.CROSS));
        board.add(new Move(new Position(0, 1), Mark.CROSS));
        board.add(new Move(new Position(1, 1), Mark.CROSS));
        board.add(new Move(new Position(2, 1), Mark.CROSS));
        board.add(new Move(new Position(3, 1), Mark.CROSS));
        board.add(new Move(new Position(6, 1), Mark.CROSS));
        board.add(new Move(new Position(0, 2), Mark.CROSS));
        board.add(new Move(new Position(1, 2), Mark.CROSS));
        board.add(new Move(new Position(2, 2), Mark.CROSS));
        board.add(new Move(new Position(3, 2), Mark.CROSS));
        board.add(new Move(new Position(6, 2), Mark.CROSS));

        // 14 NOUGHT
        board.add(new Move(new Position(5, 3), Mark.NOUGHT));
        board.add(new Move(new Position(6, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(8, 3), Mark.NOUGHT));
        board.add(new Move(new Position(5, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 4), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(8, 4), Mark.NOUGHT));
        board.add(new Move(new Position(5, 5), Mark.NOUGHT));
        board.add(new Move(new Position(6, 5), Mark.NOUGHT));
        board.add(new Move(new Position(7, 5), Mark.NOUGHT));
        board.add(new Move(new Position(8, 5), Mark.NOUGHT));
        board.add(new Move(new Position(5, 6), Mark.NOUGHT));
        board.add(new Move(new Position(6, 6), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldThrowWrongBoardStateExceptionWhenIncorrectNumberOfCrossAndNoughts() {
        assertThrows(WrongBoardStateException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.nextMove(createBoardState1(), Mark.CROSS);
        });
    }

    static Set<Move> createBoardState2() {
        Set<Move> board = new HashSet<>();

        // First Win
        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(1, 0), Mark.CROSS));
        board.add(new Move(new Position(2, 0), Mark.CROSS));
        board.add(new Move(new Position(3, 0), Mark.CROSS));
        board.add(new Move(new Position(4, 0), Mark.CROSS));

        // Second Win
        board.add(new Move(new Position(0, 2), Mark.CROSS));
        board.add(new Move(new Position(1, 2), Mark.CROSS));
        board.add(new Move(new Position(2, 2), Mark.CROSS));
        board.add(new Move(new Position(3, 2), Mark.CROSS));
        board.add(new Move(new Position(4, 2), Mark.CROSS));

        // 10 noughts
        board.add(new Move(new Position(5, 0), Mark.NOUGHT));
        board.add(new Move(new Position(6, 0), Mark.NOUGHT));
        board.add(new Move(new Position(7, 0), Mark.NOUGHT));
        board.add(new Move(new Position(8, 0), Mark.NOUGHT));
        board.add(new Move(new Position(5, 1), Mark.NOUGHT));
        board.add(new Move(new Position(6, 1), Mark.NOUGHT));
        board.add(new Move(new Position(7, 1), Mark.NOUGHT));
        board.add(new Move(new Position(8, 1), Mark.NOUGHT));
        board.add(new Move(new Position(5, 2), Mark.NOUGHT));
        board.add(new Move(new Position(6, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 2), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldThrowWrongBoardStateExceptionWhenTwoWinsForOnePlayerWithNonPeriodicBoard() {
        assertThrows(WrongBoardStateException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.nextMove(createBoardState2(), Mark.CROSS);
        });
    }

    static Set<Move> createBoardState3() {
        Set<Move> board = new HashSet<>();

        // First win (horizontal wrapping around right edge)
        board.add(new Move(new Position(10, 3), Mark.CROSS));
        board.add(new Move(new Position(11, 3), Mark.CROSS));
        board.add(new Move(new Position(0, 3), Mark.CROSS));
        board.add(new Move(new Position(1, 3), Mark.CROSS));
        board.add(new Move(new Position(2, 3), Mark.CROSS));

        // Second win (diagonal wrapping from bottom-right to top-left)
        board.add(new Move(new Position(11, 11), Mark.CROSS));
        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(1, 1), Mark.CROSS));
        board.add(new Move(new Position(2, 2), Mark.CROSS));
        board.add(new Move(new Position(3, 3), Mark.CROSS));

        // NOUGHT moves
        board.add(new Move(new Position(4, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 4), Mark.NOUGHT));
        board.add(new Move(new Position(8, 4), Mark.NOUGHT));
        board.add(new Move(new Position(5, 5), Mark.NOUGHT));
        board.add(new Move(new Position(7, 5), Mark.NOUGHT));
        board.add(new Move(new Position(9, 5), Mark.NOUGHT));
        board.add(new Move(new Position(4, 6), Mark.NOUGHT));
        board.add(new Move(new Position(6, 6), Mark.NOUGHT));
        board.add(new Move(new Position(8, 6), Mark.NOUGHT));
        board.add(new Move(new Position(5, 7), Mark.NOUGHT));
        board.add(new Move(new Position(7, 7), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldThrowWrongBoardStateExceptionWhenTwoWinsForOnePlayerWithPeriodicBoard() {
        assertThrows(WrongBoardStateException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.periodicBoundaryConditionsInUse();
            gomoku.nextMove(createBoardState3(), Mark.CROSS);
        });
    }

    static Set<Move> createBoardState4() {
        Set<Move> board = new HashSet<>();

        // CROSS - horizontal line (row 0, columns 0-4)
        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(1, 0), Mark.CROSS));
        board.add(new Move(new Position(2, 0), Mark.CROSS));
        board.add(new Move(new Position(3, 0), Mark.CROSS));
        board.add(new Move(new Position(4, 0), Mark.CROSS));

        // NOUGHT - vertical line (column 0, rows 1-5)
        board.add(new Move(new Position(0, 1), Mark.NOUGHT));
        board.add(new Move(new Position(0, 2), Mark.NOUGHT));
        board.add(new Move(new Position(0, 3), Mark.NOUGHT));
        board.add(new Move(new Position(0, 4), Mark.NOUGHT));
        board.add(new Move(new Position(0, 5), Mark.NOUGHT));

        // some additional moves to make the board more realistic (optional)
        board.add(new Move(new Position(1, 1), Mark.NOUGHT));
        board.add(new Move(new Position(2, 2), Mark.CROSS));

        return board;
    }


    @Test
    void shouldThrowWrongBoardStateExceptionWhenBothPlayersAlreadyWonWithNonPeriodicBoard() {
        assertThrows(WrongBoardStateException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.nextMove(createBoardState4(), Mark.CROSS);
        });
    }

    static Set<Move> createBoardState5() {
        Set<Move> board = new HashSet<>();

        // CROSS wins horizontally wrapping around (row 4)
        board.add(new Move(new Position(10, 4), Mark.CROSS));
        board.add(new Move(new Position(11, 4), Mark.CROSS));
        board.add(new Move(new Position(0, 4), Mark.CROSS));
        board.add(new Move(new Position(1, 4), Mark.CROSS));
        board.add(new Move(new Position(2, 4), Mark.CROSS));

        // NOUGHT wins vertically (column 7)
        board.add(new Move(new Position(7, 1), Mark.NOUGHT));
        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(7, 5), Mark.NOUGHT));

        // Additional filler moves to make board realistic (non-winning)
        board.add(new Move(new Position(5, 5), Mark.NOUGHT));
        board.add(new Move(new Position(6, 6), Mark.CROSS));
        board.add(new Move(new Position(3, 2), Mark.NOUGHT));
        board.add(new Move(new Position(8, 8), Mark.CROSS));

        return board;
    }


    @Test
    void shouldThrowWrongBoardStateExceptionWhenBothPlayersAlreadyWonWithPeriodicBoard() {
        assertThrows(WrongBoardStateException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.periodicBoundaryConditionsInUse();
            gomoku.nextMove(createBoardState5(), Mark.CROSS);
        });
    }


}