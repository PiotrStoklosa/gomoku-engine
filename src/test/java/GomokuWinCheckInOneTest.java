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


class GomokuWinCheckInOneTest {

    static Set<Move> createBoardState1() {
        Set<Move> board = new HashSet<>();

        // Random Cross
        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(2, 0), Mark.CROSS));
        board.add(new Move(new Position(4, 0), Mark.CROSS));
        board.add(new Move(new Position(6, 0), Mark.CROSS));


        //  NOUGHT is winning in one move
        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(7, 5), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldReturnProperMoveWhenWinningWithFoursMarksInRowWithNonPeriodicBoard() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        Game gomoku = new Gomoku();
        gomoku.size(12);
        Move nextMove = gomoku.nextMove(createBoardState1(), Mark.NOUGHT);
        assertTrue(
                nextMove.equals(new Move(new Position(7, 1), Mark.NOUGHT)) ||
                        nextMove.equals(new Move(new Position(7, 6), Mark.NOUGHT)),
                "Expected NOUGHT at (7,1) or (7,6), but got: " + nextMove
        );
    }

    static Set<Move> createBoardState2() {
        Set<Move> board = new HashSet<>();

        // Random Noughts
        board.add(new Move(new Position(0, 0), Mark.NOUGHT));
        board.add(new Move(new Position(2, 0), Mark.NOUGHT));
        board.add(new Move(new Position(4, 0), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));


        //  CROSS is winning in one move
        board.add(new Move(new Position(7, 0), Mark.CROSS));
        board.add(new Move(new Position(7, 1), Mark.CROSS));
        board.add(new Move(new Position(7, 2), Mark.CROSS));
        board.add(new Move(new Position(7, 11), Mark.CROSS));

        return board;
    }


    @Test
    void shouldReturnProperMoveWhenWinningWithFoursMarksInRowWithPeriodicBoard() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        Game gomoku = new Gomoku();
        gomoku.size(12);
        gomoku.periodicBoundaryConditionsInUse();
        Move nextMove = gomoku.nextMove(createBoardState2(), Mark.CROSS);
        assertEquals(nextMove, new Move(new Position(7, 10), Mark.CROSS), "Expected NOUGHT at (7,10), but got: " + nextMove);
    }

    static Set<Move> createBoardState3() {
        Set<Move> board = new HashSet<>();

        // NOUGHT - 4 in a diagonal line (left-down), missing one to win at (4,3)
        board.add(new Move(new Position(6, 1), Mark.NOUGHT));
        board.add(new Move(new Position(5, 2), Mark.NOUGHT));
        board.add(new Move(new Position(3, 4), Mark.NOUGHT));
        board.add(new Move(new Position(2, 5), Mark.NOUGHT));

        // Random CROSS positions
        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(1, 6), Mark.CROSS));
        board.add(new Move(new Position(5, 5), Mark.CROSS));
        board.add(new Move(new Position(7, 3), Mark.CROSS));

        return board;
    }

    @Test
    void shouldReturnProperMoveWhenWinningWithFiveMarksInRowWithHoleWithNonPeriodicBoard() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        Game gomoku = new Gomoku();
        gomoku.size(12);
        Move nextMove = gomoku.nextMove(createBoardState3(), Mark.NOUGHT);
        assertEquals(new Move(new Position(4, 3), Mark.NOUGHT), nextMove, "Expected NOUGHT at (4,3), but got: " + nextMove);
    }

    static Set<Move> createBoardState4() {
        Set<Move> board = new HashSet<>();

        // NOUGHT diagonal ↙ crossing the border (periodic), missing (2, 1)
        board.add(new Move(new Position(0, 11), Mark.NOUGHT));
        board.add(new Move(new Position(1, 0), Mark.NOUGHT));
        // board.add(new Move(new Position(2, 1), Mark.NOUGHT)); // missing
        board.add(new Move(new Position(3, 2), Mark.NOUGHT));
        board.add(new Move(new Position(4, 3), Mark.NOUGHT));

        // Random CROSS moves
        board.add(new Move(new Position(6, 5), Mark.CROSS));
        board.add(new Move(new Position(8, 8), Mark.CROSS));
        board.add(new Move(new Position(9, 1), Mark.CROSS));
        board.add(new Move(new Position(11, 6), Mark.CROSS));

        return board;
    }

    @Test
    void shouldReturnProperMoveWhenWinningWithFiveMarksInRowWithHoleWithPeriodicBoard() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        Game gomoku = new Gomoku();
        gomoku.size(12);
        gomoku.periodicBoundaryConditionsInUse();
        Move nextMove = gomoku.nextMove(createBoardState4(), Mark.NOUGHT);
        assertEquals( new Move(new Position(2, 1), Mark.NOUGHT), nextMove, "Expected NOUGHT at (2,1), but got: " + nextMove);
    }

}