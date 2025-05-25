import fais.zti.oramus.gomoku.Game;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import fais.zti.oramus.gomoku.ResignException;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.TestUtil.printBoard;

public class GomokuOpponentWinInTwoTest {

    static Set<Move> createBoardState1() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(2, 0), Mark.CROSS));
        board.add(new Move(new Position(4, 0), Mark.CROSS));
        board.add(new Move(new Position(6, 0), Mark.CROSS));
        board.add(new Move(new Position(8, 0), Mark.CROSS));

        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 3), Mark.NOUGHT));
        board.add(new Move(new Position(8, 3), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldResignWhenOpponentWinsInTwoMovesWithCross() {
        printBoard(createBoardState1(), Mark.CROSS, false, Mark.CROSS);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.CROSS);
            Move nextMove = gomoku.nextMove(createBoardState1(), Mark.CROSS);
            System.out.println("Expected ResignException, got " + nextMove);
        });
    }

    static Set<Move> createBoardState2() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.NOUGHT));
        board.add(new Move(new Position(2, 0), Mark.NOUGHT));
        board.add(new Move(new Position(4, 0), Mark.NOUGHT));
        board.add(new Move(new Position(3, 3), Mark.NOUGHT));
        board.add(new Move(new Position(2, 8), Mark.NOUGHT));

        board.add(new Move(new Position(7, 0), Mark.CROSS));
        board.add(new Move(new Position(7, 1), Mark.CROSS));
        board.add(new Move(new Position(6, 0), Mark.CROSS));
        board.add(new Move(new Position(8, 0), Mark.CROSS));
        board.add(new Move(new Position(7, 11), Mark.CROSS));

        return board;
    }


    @Test
    void shouldResignWhenOpponentWinsInTwoMovesWithCrossOnPeriodicBoard() {
        printBoard(createBoardState2(), Mark.NOUGHT, true, Mark.NOUGHT);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.NOUGHT);
            gomoku.periodicBoundaryConditionsInUse();
            Move nextMove = gomoku.nextMove(createBoardState2(), Mark.NOUGHT);
            System.out.println("Expected ResignException, got " + nextMove);
        });
    }

    static Set<Move> createBoardState3() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(2, 0), Mark.CROSS));
        board.add(new Move(new Position(4, 0), Mark.CROSS));
        board.add(new Move(new Position(6, 10), Mark.CROSS));
        board.add(new Move(new Position(1, 10), Mark.CROSS));

        board.add(new Move(new Position(8, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(6, 2), Mark.NOUGHT));
        board.add(new Move(new Position(6, 4), Mark.NOUGHT));
        board.add(new Move(new Position(8, 4), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldResignWhenOpponentWinsInTwoMovesWithDiagonalCross() {
        printBoard(createBoardState3(), Mark.CROSS, false, Mark.CROSS);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.CROSS);
            Move nextMove = gomoku.nextMove(createBoardState3(), Mark.CROSS);
            System.out.println("Expected ResignException, got " + nextMove);
        });
    }

    static Set<Move> createBoardState4() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.NOUGHT));
        board.add(new Move(new Position(2, 10), Mark.NOUGHT));
        board.add(new Move(new Position(4, 10), Mark.NOUGHT));
        board.add(new Move(new Position(3, 3), Mark.NOUGHT));
        board.add(new Move(new Position(2, 8), Mark.NOUGHT));

        board.add(new Move(new Position(7, 0), Mark.CROSS));
        board.add(new Move(new Position(6, 1), Mark.CROSS));
        board.add(new Move(new Position(8, 1), Mark.CROSS));
        board.add(new Move(new Position(6, 11), Mark.CROSS));
        board.add(new Move(new Position(8, 11), Mark.CROSS));

        return board;
    }

    @Test
    void shouldResignWhenOpponentWinsInTwoMovesWithDiagonalCrossOnPeriodicBoard() {
        printBoard(createBoardState4(), Mark.NOUGHT, true, Mark.NOUGHT);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.NOUGHT);
            gomoku.periodicBoundaryConditionsInUse();
            Move nextMove = gomoku.nextMove(createBoardState4(), Mark.NOUGHT);
            System.out.println("Expected ResignException, got " + nextMove);
        });
    }

    static Set<Move> createBoardState5() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.NOUGHT));
        board.add(new Move(new Position(2, 10), Mark.NOUGHT));
        board.add(new Move(new Position(4, 10), Mark.NOUGHT));
        board.add(new Move(new Position(3, 3), Mark.NOUGHT));
        board.add(new Move(new Position(2, 8), Mark.NOUGHT));

        board.add(new Move(new Position(9, 2), Mark.CROSS));
        board.add(new Move(new Position(9, 3), Mark.CROSS));
        board.add(new Move(new Position(9, 4), Mark.CROSS));
        board.add(new Move(new Position(8, 4), Mark.CROSS));
        board.add(new Move(new Position(7, 4), Mark.CROSS));

        return board;
    }

    @Test
    void shouldResignWhenOpponentWinsInTwoMovesWithL() {
        printBoard(createBoardState5(), Mark.NOUGHT, false, Mark.NOUGHT);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.NOUGHT);
            Move nextMove = gomoku.nextMove(createBoardState5(), Mark.NOUGHT);
            System.out.println("Expected ResignException, got " + nextMove);
        });
    }

    static Set<Move> createBoardState6() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.NOUGHT));
        board.add(new Move(new Position(2, 10), Mark.NOUGHT));
        board.add(new Move(new Position(4, 10), Mark.NOUGHT));
        board.add(new Move(new Position(3, 3), Mark.NOUGHT));
        board.add(new Move(new Position(2, 8), Mark.NOUGHT));

        board.add(new Move(new Position(7, 2), Mark.CROSS));
        board.add(new Move(new Position(8, 1), Mark.CROSS));
        board.add(new Move(new Position(9, 0), Mark.CROSS));
        board.add(new Move(new Position(7, 10), Mark.CROSS));
        board.add(new Move(new Position(8, 11), Mark.CROSS));

        return board;
    }

    @Test
    void shouldResignWhenOpponentWinsInTwoMovesWithLOnPeriodicBoard() {
        printBoard(createBoardState6(), Mark.NOUGHT, true, Mark.NOUGHT);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.NOUGHT);
            gomoku.periodicBoundaryConditionsInUse();
            Move nextMove = gomoku.nextMove(createBoardState6(), Mark.NOUGHT);
            System.out.println("Expected ResignException, got " + nextMove);
        });
    }

}
