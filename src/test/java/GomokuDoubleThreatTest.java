import fais.zti.oramus.gomoku.Game;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.TestUtil.printBoard;

public class GomokuDoubleThreatTest {

    static Set<Move> createBoardState1() {

        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(3, 0), Mark.CROSS));
        board.add(new Move(new Position(6, 0), Mark.CROSS));
        board.add(new Move(new Position(9, 0), Mark.CROSS));

        board.add(new Move(new Position(0, 10), Mark.CROSS));
        board.add(new Move(new Position(3, 10), Mark.CROSS));
        board.add(new Move(new Position(6, 10), Mark.CROSS));
        board.add(new Move(new Position(9, 10), Mark.CROSS));

        board.add(new Move(new Position(6, 2), Mark.NOUGHT));
        board.add(new Move(new Position(6, 3), Mark.NOUGHT));
        board.add(new Move(new Position(6, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 6), Mark.NOUGHT));

        board.add(new Move(new Position(3, 3), Mark.NOUGHT));
        board.add(new Move(new Position(3, 4), Mark.NOUGHT));
        board.add(new Move(new Position(3, 5), Mark.NOUGHT));
        board.add(new Move(new Position(3, 7), Mark.NOUGHT));


        return board;
    }

    @Test
    void shouldResignWhenDoubleThreatWithNonPeriodicBoard() {
        printBoard(createBoardState1(), Mark.CROSS, false, Mark.CROSS);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.CROSS);
            System.out.println("Should throw Resign Exception, but got move instead: " + gomoku.nextMove(createBoardState1(), Mark.CROSS));
        });
    }

    static Set<Move> createBoardState2() {

        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(3, 0), Mark.CROSS));
        board.add(new Move(new Position(6, 0), Mark.CROSS));
        board.add(new Move(new Position(9, 0), Mark.CROSS));

        board.add(new Move(new Position(0, 10), Mark.CROSS));
        board.add(new Move(new Position(3, 10), Mark.CROSS));

        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(6, 3), Mark.NOUGHT));

        board.add(new Move(new Position(3, 3), Mark.NOUGHT));
        board.add(new Move(new Position(3, 4), Mark.NOUGHT));
        board.add(new Move(new Position(4, 5), Mark.NOUGHT));
        board.add(new Move(new Position(5, 5), Mark.NOUGHT));


        return board;
    }

    @Test
    void shouldResignWhenDoubleThreatWithLAndFourWithNonPeriodicBoard() {
        printBoard(createBoardState2(), Mark.CROSS, false, Mark.CROSS);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.CROSS);
            System.out.println("Should throw Resign Exception, but got move instead: " + gomoku.nextMove(createBoardState2(), Mark.CROSS));
        });
    }


    static Set<Move> createBoardState3() {

        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(3, 0), Mark.CROSS));
        board.add(new Move(new Position(6, 0), Mark.CROSS));
        board.add(new Move(new Position(9, 0), Mark.CROSS));

        board.add(new Move(new Position(0, 10), Mark.CROSS));
        board.add(new Move(new Position(3, 10), Mark.CROSS));
        board.add(new Move(new Position(6, 10), Mark.CROSS));
        board.add(new Move(new Position(9, 10), Mark.CROSS));

        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 3), Mark.NOUGHT));
        board.add(new Move(new Position(8, 3), Mark.NOUGHT));

        board.add(new Move(new Position(3, 2), Mark.NOUGHT));
        board.add(new Move(new Position(3, 4), Mark.NOUGHT));
        board.add(new Move(new Position(2, 3), Mark.NOUGHT));
        board.add(new Move(new Position(4, 3), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldResignWhenDoubleThreatWithCrossWithNonPeriodicBoard() {
        printBoard(createBoardState3(), Mark.CROSS, false, Mark.CROSS);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.CROSS);
            System.out.println("Should throw Resign Exception, but got move instead: " + gomoku.nextMove(createBoardState3(), Mark.CROSS));
        });

    }

    static Set<Move> createBoardState4() {

        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(3, 0), Mark.CROSS));
        board.add(new Move(new Position(6, 0), Mark.CROSS));
        board.add(new Move(new Position(2, 5), Mark.CROSS));

        board.add(new Move(new Position(0, 10), Mark.CROSS));
        board.add(new Move(new Position(3, 10), Mark.CROSS));
        board.add(new Move(new Position(6, 10), Mark.CROSS));

        board.add(new Move(new Position(6, 2), Mark.NOUGHT));
        board.add(new Move(new Position(6, 3), Mark.NOUGHT));
        board.add(new Move(new Position(6, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 6), Mark.NOUGHT));

        board.add(new Move(new Position(11, 10), Mark.NOUGHT));
        board.add(new Move(new Position(11, 11), Mark.NOUGHT));
        board.add(new Move(new Position(11, 0), Mark.NOUGHT));


        return board;
    }

    @Test
    void shouldResignWhenDoubleDifferentThreatWithPeriodicBoard() {
        printBoard(createBoardState4(), Mark.CROSS, true, Mark.CROSS);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.CROSS);
            gomoku.periodicBoundaryConditionsInUse();
            System.out.println("Should throw Resign Exception, but got move instead: " + gomoku.nextMove(createBoardState4(), Mark.CROSS));
        });
    }

    static Set<Move> createBoardState5() {

        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(3, 0), Mark.CROSS));
        board.add(new Move(new Position(6, 0), Mark.CROSS));
        board.add(new Move(new Position(2, 5), Mark.CROSS));

        board.add(new Move(new Position(0, 10), Mark.CROSS));
        board.add(new Move(new Position(3, 10), Mark.CROSS));
        board.add(new Move(new Position(11, 9), Mark.CROSS));

        board.add(new Move(new Position(6, 2), Mark.NOUGHT));
        board.add(new Move(new Position(6, 3), Mark.NOUGHT));
        board.add(new Move(new Position(6, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 6), Mark.NOUGHT));

        board.add(new Move(new Position(11, 10), Mark.NOUGHT));
        board.add(new Move(new Position(11, 11), Mark.NOUGHT));
        board.add(new Move(new Position(11, 0), Mark.NOUGHT));


        return board;
    }

    @Test
    void shouldReturnProperMoveWhenDoubleMockDifferentThreatWithPeriodicBoard() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        printBoard(createBoardState5(), Mark.CROSS, true, Mark.CROSS);
        Game gomoku = new Gomoku();
        gomoku.size(12);
        gomoku.firstMark(Mark.CROSS);
        gomoku.periodicBoundaryConditionsInUse();
        Move nextMove = gomoku.nextMove(createBoardState5(), Mark.CROSS);
        assertEquals(nextMove, new Move(new Position(6, 5), Mark.CROSS), "Expected CROSS at (6,5), but got: " + nextMove);
    }

    static Set<Move> createBoardState6() {

        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(3, 0), Mark.CROSS));
        board.add(new Move(new Position(6, 0), Mark.CROSS));
        board.add(new Move(new Position(9, 0), Mark.CROSS));

        board.add(new Move(new Position(0, 10), Mark.CROSS));
        board.add(new Move(new Position(3, 10), Mark.CROSS));
        board.add(new Move(new Position(5, 10), Mark.CROSS));
        board.add(new Move(new Position(11, 11), Mark.CROSS));

        board.add(new Move(new Position(7, 7), Mark.NOUGHT));
        board.add(new Move(new Position(7, 9), Mark.NOUGHT));
        board.add(new Move(new Position(8, 7), Mark.NOUGHT));
        board.add(new Move(new Position(9, 6), Mark.NOUGHT));

        board.add(new Move(new Position(3, 3), Mark.NOUGHT));
        board.add(new Move(new Position(3, 4), Mark.NOUGHT));
        board.add(new Move(new Position(4, 5), Mark.NOUGHT));
        board.add(new Move(new Position(5, 5), Mark.NOUGHT));


        return board;
    }

    @Test
    void shouldResignWhenDoubleThreatWithLAndCrossWithNonPeriodicBoard() {
        printBoard(createBoardState6(), Mark.CROSS, false, Mark.CROSS);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.CROSS);
            System.out.println("Should throw Resign Exception, but got move instead: " + gomoku.nextMove(createBoardState6(), Mark.CROSS));
        });
    }

    static Set<Move> createBoardState7() {

        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(3, 2), Mark.CROSS));
        board.add(new Move(new Position(2, 6), Mark.CROSS));
        board.add(new Move(new Position(3, 0), Mark.CROSS));
        board.add(new Move(new Position(6, 0), Mark.CROSS));
        board.add(new Move(new Position(10, 0), Mark.CROSS));
        board.add(new Move(new Position(0, 4), Mark.CROSS));
        board.add(new Move(new Position(0, 7), Mark.CROSS));

        board.add(new Move(new Position(0, 10), Mark.CROSS));
        board.add(new Move(new Position(3, 10), Mark.CROSS));
        board.add(new Move(new Position(5, 10), Mark.CROSS));
        board.add(new Move(new Position(6, 7), Mark.CROSS));

        board.add(new Move(new Position(8, 4), Mark.NOUGHT));
        board.add(new Move(new Position(8, 6), Mark.NOUGHT));
        board.add(new Move(new Position(9, 4), Mark.NOUGHT));
        board.add(new Move(new Position(7, 6), Mark.NOUGHT));

        board.add(new Move(new Position(3, 3), Mark.NOUGHT));
        board.add(new Move(new Position(3, 4), Mark.NOUGHT));
        board.add(new Move(new Position(4, 5), Mark.NOUGHT));
        board.add(new Move(new Position(5, 5), Mark.NOUGHT));

        board.add(new Move(new Position(11, 11), Mark.NOUGHT));
        board.add(new Move(new Position(10, 11), Mark.NOUGHT));
        board.add(new Move(new Position(9, 10), Mark.NOUGHT));
        board.add(new Move(new Position(9, 9), Mark.NOUGHT));


        return board;
    }

    @Test
    void shouldReturnProperMoveWhenMockingThreatsWithThreeLinesThreatWithPeriodicBoard() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        printBoard(createBoardState7(), Mark.CROSS, true, Mark.CROSS);
        Game gomoku = new Gomoku();
        gomoku.size(12);
        gomoku.periodicBoundaryConditionsInUse();
        gomoku.firstMark(Mark.CROSS);
        Move nextMove = gomoku.nextMove(createBoardState7(), Mark.CROSS);
        assertEquals(nextMove, new Move(new Position(9, 11), Mark.CROSS), "Expected CROSS at (9,11), but got: " + nextMove);
    }

    static Set<Move> createBoardState8() {

        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(3, 2), Mark.CROSS));
        board.add(new Move(new Position(3, 6), Mark.CROSS));
        board.add(new Move(new Position(9, 0), Mark.CROSS));

        board.add(new Move(new Position(0, 10), Mark.CROSS));
        board.add(new Move(new Position(3, 10), Mark.CROSS));
        board.add(new Move(new Position(6, 10), Mark.CROSS));
        board.add(new Move(new Position(11, 11), Mark.CROSS));

        board.add(new Move(new Position(7, 7), Mark.NOUGHT));
        board.add(new Move(new Position(7, 9), Mark.NOUGHT));
        board.add(new Move(new Position(8, 7), Mark.NOUGHT));
        board.add(new Move(new Position(6, 9), Mark.NOUGHT));

        board.add(new Move(new Position(3, 3), Mark.NOUGHT));
        board.add(new Move(new Position(3, 4), Mark.NOUGHT));
        board.add(new Move(new Position(4, 5), Mark.NOUGHT));
        board.add(new Move(new Position(5, 5), Mark.NOUGHT));


        return board;
    }

    @Test
    void shouldReturnProperMoveWhenDoubleMockWithThreeLinesThreatWithPeriodicBoard() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        printBoard(createBoardState8(), Mark.CROSS, true, Mark.CROSS);
        Game gomoku = new Gomoku();
        gomoku.size(12);
        gomoku.periodicBoundaryConditionsInUse();
        gomoku.firstMark(Mark.CROSS);
        Move nextMove = gomoku.nextMove(createBoardState8(), Mark.CROSS);
        assertEquals(nextMove, new Move(new Position(7, 8), Mark.CROSS), "Expected CROSS at (7,8), but got: " + nextMove);
    }

}
