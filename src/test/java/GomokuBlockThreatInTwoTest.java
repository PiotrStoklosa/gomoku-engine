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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static util.TestUtil.printBoard;

public class GomokuBlockThreatInTwoTest {

    static Set<Move> createBoardState1() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(2, 0), Mark.CROSS));
        board.add(new Move(new Position(4, 0), Mark.CROSS));

        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldReturnProperMoveWhenBlockingInTwoWithThreeMarksInRowWithNonPeriodicBoard() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        printBoard(createBoardState1(), Mark.CROSS, false, Mark.CROSS);
        Game gomoku = new Gomoku();
        gomoku.size(12);
        gomoku.firstMark(Mark.CROSS);
        Move nextMove = gomoku.nextMove(createBoardState1(), Mark.CROSS);
        assertTrue(
                nextMove.equals(new Move(new Position(7, 1), Mark.CROSS)) ||
                        nextMove.equals(new Move(new Position(7, 5), Mark.CROSS)),
                "Expected CROSS at (7,1) or (7,5), but got: " + nextMove
        );
    }

    static Set<Move> createBoardState2() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(2, 0), Mark.NOUGHT));
        board.add(new Move(new Position(4, 0), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));

        board.add(new Move(new Position(7, 0), Mark.CROSS));
        board.add(new Move(new Position(7, 1), Mark.CROSS));
        board.add(new Move(new Position(7, 11), Mark.CROSS));

        return board;
    }


    @Test
    void shouldReturnProperMoveWhenBlockingWithThreeMarksInRowWithPeriodicBoard() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        printBoard(createBoardState2(), Mark.NOUGHT, true, Mark.NOUGHT);
        Game gomoku = new Gomoku();
        gomoku.size(12);
        gomoku.firstMark(Mark.NOUGHT);
        gomoku.periodicBoundaryConditionsInUse();
        Move nextMove = gomoku.nextMove(createBoardState2(), Mark.NOUGHT);
        assertTrue(
                nextMove.equals(new Move(new Position(7, 2), Mark.NOUGHT)) ||
                        nextMove.equals(new Move(new Position(7, 10), Mark.NOUGHT)),
                "Expected NOUGHT at (7,2) or (7,10), but got: " + nextMove
        );
    }

    static Set<Move> createBoardState3() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(6, 1), Mark.NOUGHT));
        board.add(new Move(new Position(5, 2), Mark.NOUGHT));
        board.add(new Move(new Position(3, 4), Mark.NOUGHT));

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(1, 6), Mark.CROSS));
        board.add(new Move(new Position(5, 5), Mark.CROSS));

        return board;
    }

    @Test
    void shouldReturnProperMoveWhenBlockingInTwoWithFourMarksInRowWithHoleWithNonPeriodicBoard() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        printBoard(createBoardState3(), Mark.CROSS, false, Mark.CROSS);
        Game gomoku = new Gomoku();
        gomoku.size(12);
        gomoku.firstMark(Mark.CROSS);
        Move nextMove = gomoku.nextMove(createBoardState3(), Mark.CROSS);
        assertEquals(new Move(new Position(4, 3), Mark.CROSS), nextMove, "Expected CROSS at (4,3), but got: " + nextMove);
    }

    static Set<Move> createBoardState4() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 11), Mark.NOUGHT));
        board.add(new Move(new Position(1, 0), Mark.NOUGHT));
        board.add(new Move(new Position(3, 2), Mark.NOUGHT));

        board.add(new Move(new Position(5, 4), Mark.CROSS));
        board.add(new Move(new Position(8, 8), Mark.CROSS));
        board.add(new Move(new Position(9, 1), Mark.CROSS));

        return board;
    }

    @Test
    void shouldReturnProperMoveWhenBlockingInTwoWithFourMarksInRowWithHoleWithPeriodicBoard() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        printBoard(createBoardState4(), Mark.CROSS, true, Mark.CROSS);
        Game gomoku = new Gomoku();
        gomoku.size(12);
        gomoku.firstMark(Mark.CROSS);
        gomoku.periodicBoundaryConditionsInUse();
        Move nextMove = gomoku.nextMove(createBoardState4(), Mark.CROSS);
        assertEquals( new Move(new Position(2, 1), Mark.CROSS), nextMove, "Expected CROSS at (2,1), but got: " + nextMove);
    }
}
