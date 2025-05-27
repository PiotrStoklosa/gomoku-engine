import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import fais.zti.oramus.gomoku.WrongBoardStateException;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.TestUtil.printBoard;

class GomokuWrongStateTest {

    static Set<Move> createBoardState1() {
        Set<Move> board = new HashSet<>();

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
        printBoard(createBoardState1(), Mark.CROSS, false, Mark.CROSS);
        assertThrows(WrongBoardStateException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.CROSS);
            gomoku.nextMove(createBoardState1(), Mark.CROSS);
        });
    }

/*    static Set<Move> createBoardState2() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(1, 0), Mark.CROSS));
        board.add(new Move(new Position(2, 0), Mark.CROSS));
        board.add(new Move(new Position(3, 0), Mark.CROSS));
        board.add(new Move(new Position(4, 0), Mark.CROSS));

        board.add(new Move(new Position(0, 2), Mark.CROSS));
        board.add(new Move(new Position(1, 2), Mark.CROSS));
        board.add(new Move(new Position(2, 2), Mark.CROSS));
        board.add(new Move(new Position(3, 2), Mark.CROSS));
        board.add(new Move(new Position(4, 2), Mark.CROSS));

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
        printBoard(createBoardState2(), Mark.NOUGHT, false, Mark.CROSS);
        assertThrows(WrongBoardStateException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.NOUGHT);
            gomoku.nextMove(createBoardState2(), Mark.CROSS);
        });
    }*/

/*    static Set<Move> createBoardState3() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(10, 3), Mark.CROSS));
        board.add(new Move(new Position(11, 3), Mark.CROSS));
        board.add(new Move(new Position(0, 3), Mark.CROSS));
        board.add(new Move(new Position(1, 3), Mark.CROSS));
        board.add(new Move(new Position(2, 3), Mark.CROSS));

        board.add(new Move(new Position(11, 11), Mark.CROSS));
        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(1, 1), Mark.CROSS));
        board.add(new Move(new Position(2, 2), Mark.CROSS));
        board.add(new Move(new Position(3, 3), Mark.CROSS));

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

        return board;
    }

    @Test
    void shouldThrowWrongBoardStateExceptionWhenTwoWinsForOnePlayerWithPeriodicBoard() {
        printBoard(createBoardState3(), Mark.CROSS, true, Mark.CROSS);
        assertThrows(WrongBoardStateException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.CROSS);
            gomoku.periodicBoundaryConditionsInUse();
            gomoku.nextMove(createBoardState3(), Mark.CROSS);
        });
    }*/

/*    static Set<Move> createBoardState4() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(1, 0), Mark.CROSS));
        board.add(new Move(new Position(2, 0), Mark.CROSS));
        board.add(new Move(new Position(3, 0), Mark.CROSS));
        board.add(new Move(new Position(4, 0), Mark.CROSS));

        board.add(new Move(new Position(0, 1), Mark.NOUGHT));
        board.add(new Move(new Position(0, 2), Mark.NOUGHT));
        board.add(new Move(new Position(0, 3), Mark.NOUGHT));
        board.add(new Move(new Position(0, 4), Mark.NOUGHT));
        board.add(new Move(new Position(0, 5), Mark.NOUGHT));

        board.add(new Move(new Position(1, 1), Mark.NOUGHT));
        board.add(new Move(new Position(2, 2), Mark.CROSS));

        return board;
    }


    @Test
    void shouldThrowWrongBoardStateExceptionWhenBothPlayersAlreadyWonWithNonPeriodicBoard() {
        printBoard(createBoardState4(), Mark.CROSS, false, Mark.CROSS);
        assertThrows(WrongBoardStateException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.CROSS);
            gomoku.nextMove(createBoardState4(), Mark.CROSS);
        });
    }*/

/*    static Set<Move> createBoardState5() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(10, 4), Mark.CROSS));
        board.add(new Move(new Position(11, 4), Mark.CROSS));
        board.add(new Move(new Position(0, 4), Mark.CROSS));
        board.add(new Move(new Position(1, 4), Mark.CROSS));
        board.add(new Move(new Position(2, 4), Mark.CROSS));

        board.add(new Move(new Position(7, 1), Mark.NOUGHT));
        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(7, 5), Mark.NOUGHT));

        board.add(new Move(new Position(5, 5), Mark.NOUGHT));
        board.add(new Move(new Position(6, 6), Mark.CROSS));
        board.add(new Move(new Position(3, 2), Mark.NOUGHT));
        board.add(new Move(new Position(8, 8), Mark.CROSS));

        return board;
    }


    @Test
    void shouldThrowWrongBoardStateExceptionWhenBothPlayersAlreadyWonWithPeriodicBoard() {
        printBoard(createBoardState5(), Mark.CROSS, true, Mark.CROSS);
        assertThrows(WrongBoardStateException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.CROSS);
            gomoku.periodicBoundaryConditionsInUse();
            gomoku.nextMove(createBoardState5(), Mark.CROSS);
        });
    }*/


    static Set<Move> createBoardState7() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(10, 4), Mark.CROSS));
        board.add(new Move(new Position(10, 5), Mark.CROSS));

        board.add(new Move(new Position(10, 4), Mark.NOUGHT));

        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));

        return board;
    }


    @Test
    void shouldThrowWrongBoardStateExceptionWhenTheSamePositionIsUsed2() {
        printBoard(createBoardState7(), Mark.NOUGHT, false, Mark.NOUGHT);
        assertThrows(WrongBoardStateException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.NOUGHT);
            gomoku.nextMove(createBoardState7(), Mark.NOUGHT);
        });
    }

}