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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static util.TestUtil.printBoard;

public class DiscordAndMixTest {
    static Set<Move> createBoardState1() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(4, 2), Mark.NOUGHT));
        board.add(new Move(new Position(5, 2), Mark.NOUGHT));
        board.add(new Move(new Position(6, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 2), Mark.NOUGHT));

        board.add(new Move(new Position(3, 3), Mark.NOUGHT));
        board.add(new Move(new Position(4, 3), Mark.CROSS));
        board.add(new Move(new Position(5, 3), Mark.CROSS));
        board.add(new Move(new Position(6, 3), Mark.CROSS));
        board.add(new Move(new Position(7, 3), Mark.CROSS));
        board.add(new Move(new Position(8, 3), Mark.CROSS));

        board.add(new Move(new Position(3, 4), Mark.NOUGHT));
        board.add(new Move(new Position(4, 4), Mark.NOUGHT));
        board.add(new Move(new Position(5, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 4), Mark.NOUGHT));

        board.add(new Move(new Position(3, 5), Mark.NOUGHT));
        board.add(new Move(new Position(4, 5), Mark.CROSS));
        board.add(new Move(new Position(5, 5), Mark.CROSS));
        board.add(new Move(new Position(6, 5), Mark.CROSS));
        board.add(new Move(new Position(7, 5), Mark.CROSS));
        board.add(new Move(new Position(8, 5), Mark.CROSS));

        return board;
    }


    @Test
    void shouldThrowWrongBoardStateExceptionWhenTwoWinsForOnePlayerWithNonPeriodicBoard() {
        printBoard(createBoardState1(), Mark.NOUGHT, false, Mark.NOUGHT);
        assertThrows(WrongBoardStateException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(10);
            gomoku.firstMark(Mark.NOUGHT);
            gomoku.nextMove(createBoardState1(), Mark.NOUGHT);
        });

    }

    static Set<Move> createBoardState2() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(4, 0), Mark.NOUGHT));
        board.add(new Move(new Position(5, 0), Mark.NOUGHT));
        board.add(new Move(new Position(6, 0), Mark.NOUGHT));
        board.add(new Move(new Position(8, 0), Mark.CROSS));

        board.add(new Move(new Position(1, 1), Mark.CROSS));
        board.add(new Move(new Position(4, 1), Mark.NOUGHT));
        board.add(new Move(new Position(5, 1), Mark.NOUGHT));
        board.add(new Move(new Position(6, 1), Mark.NOUGHT));
        board.add(new Move(new Position(7, 1), Mark.CROSS));

        board.add(new Move(new Position(2, 2), Mark.CROSS));
        board.add(new Move(new Position(4, 2), Mark.NOUGHT));
        board.add(new Move(new Position(5, 2), Mark.NOUGHT));
        board.add(new Move(new Position(6, 2), Mark.CROSS));

        board.add(new Move(new Position(3, 3), Mark.CROSS));
        board.add(new Move(new Position(4, 3), Mark.NOUGHT));
        board.add(new Move(new Position(5, 3), Mark.CROSS));

        board.add(new Move(new Position(4, 4), Mark.CROSS));

        return board;
    }


    @Test
    void shouldThrowTheWinnerIsExceptionWhenOneWinForOnePlayerWithNonPeriodicBoard() {
        printBoard(createBoardState2(), Mark.NOUGHT, false, Mark.NOUGHT);
        TheWinnerIsException ex = assertThrows(TheWinnerIsException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(10);
            gomoku.firstMark(Mark.NOUGHT);
            gomoku.nextMove(createBoardState2(), Mark.NOUGHT);
        });
        assertEquals(Mark.CROSS, ex.mark);
    }

    static Set<Move> createBoardState3() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(4, 3), Mark.CROSS));
        board.add(new Move(new Position(5, 3), Mark.CROSS));
        board.add(new Move(new Position(6, 3), Mark.CROSS));
        board.add(new Move(new Position(7, 3), Mark.CROSS));
        board.add(new Move(new Position(8, 3), Mark.CROSS));

        board.add(new Move(new Position(4, 4), Mark.NOUGHT));
        board.add(new Move(new Position(5, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 4), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(8, 4), Mark.NOUGHT));

        return board;
    }


    @Test
    void shouldThrowWrongBoardStateExceptionWhenOneWinForXAndOneWinForOWithNonPeriodicBoard() {
        printBoard(createBoardState3(), Mark.NOUGHT, false, Mark.NOUGHT);
        assertThrows(WrongBoardStateException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(10);
            gomoku.firstMark(Mark.NOUGHT);
            gomoku.nextMove(createBoardState3(), Mark.NOUGHT);
        });
    }

    static Set<Move> createBoardState4() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(2, 0), Mark.NOUGHT));
        board.add(new Move(new Position(3, 0), Mark.NOUGHT));
        board.add(new Move(new Position(4, 0), Mark.NOUGHT));

        board.add(new Move(new Position(1, 1), Mark.NOUGHT));
        board.add(new Move(new Position(2, 1), Mark.CROSS));
        board.add(new Move(new Position(3, 1), Mark.CROSS));
        board.add(new Move(new Position(4, 1), Mark.CROSS));
        board.add(new Move(new Position(5, 1), Mark.NOUGHT));
        board.add(new Move(new Position(6, 1), Mark.NOUGHT));
        board.add(new Move(new Position(7, 1), Mark.NOUGHT));

        board.add(new Move(new Position(1, 2), Mark.CROSS));
        board.add(new Move(new Position(6, 2), Mark.NOUGHT));

        board.add(new Move(new Position(2, 3), Mark.CROSS));
        board.add(new Move(new Position(6, 3), Mark.CROSS));

        board.add(new Move(new Position(3, 4), Mark.CROSS));
        board.add(new Move(new Position(5, 4), Mark.CROSS));

        board.add(new Move(new Position(3, 5), Mark.NOUGHT));
        board.add(new Move(new Position(4, 5), Mark.CROSS));

        board.add(new Move(new Position(4, 6), Mark.CROSS));

        return board;
    }

    @Test
    void shouldResignWhenOpponentWinInOneWithNonPeriodicBoard() {
        printBoard(createBoardState4(), Mark.CROSS, false, Mark.NOUGHT);
        assertThrows(ResignException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(10);
            gomoku.firstMark(Mark.CROSS);
            gomoku.nextMove(createBoardState4(), Mark.NOUGHT);
        });
    }

    static Set<Move> createBoardState5() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(1, 11), Mark.CROSS));
        board.add(new Move(new Position(2, 11), Mark.CROSS));
        board.add(new Move(new Position(3, 11), Mark.CROSS));
        board.add(new Move(new Position(7, 11), Mark.CROSS));
        board.add(new Move(new Position(8, 11), Mark.CROSS));

        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 3), Mark.NOUGHT));
        board.add(new Move(new Position(8, 3), Mark.NOUGHT));

        board.add(new Move(new Position(0, 11), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldResignWhenOpponentWinsInTwoMovesWithCross1() {
        printBoard(createBoardState5(), Mark.NOUGHT, false, Mark.CROSS);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.NOUGHT);
            Move nextMove = gomoku.nextMove(createBoardState5(), Mark.CROSS);
            System.out.println("Expected ResignException, got " + nextMove);
        });

    }

    static Set<Move> createBoardState6() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 11), Mark.CROSS));
        board.add(new Move(new Position(1, 11), Mark.CROSS));
        board.add(new Move(new Position(2, 11), Mark.CROSS));
        board.add(new Move(new Position(7, 11), Mark.CROSS));
        board.add(new Move(new Position(8, 11), Mark.CROSS));

        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 3), Mark.NOUGHT));
        board.add(new Move(new Position(8, 3), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldResignWhenOpponentWinsInTwoMovesWithCross2() {
        printBoard(createBoardState6(), Mark.CROSS, false, Mark.CROSS);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.CROSS);
            Move nextMove = gomoku.nextMove(createBoardState6(), Mark.CROSS);
            System.out.println("Expected ResignException, got " + nextMove);
        });

    }

    static Set<Move> createBoardState7() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 11), Mark.CROSS));
        board.add(new Move(new Position(1, 11), Mark.CROSS));
        board.add(new Move(new Position(2, 11), Mark.CROSS));
        board.add(new Move(new Position(7, 11), Mark.CROSS));
        board.add(new Move(new Position(8, 11), Mark.CROSS));

        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 3), Mark.NOUGHT));
        board.add(new Move(new Position(8, 3), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldReturnMoveToWinInTwoWithPeriodic() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        printBoard(createBoardState7(), Mark.CROSS, false, Mark.CROSS);
        Game gomoku = new Gomoku();
        gomoku.size(12);
        gomoku.periodicBoundaryConditionsInUse();
        gomoku.firstMark(Mark.CROSS);
        Move nextMove = gomoku.nextMove(createBoardState7(), Mark.CROSS);
        assertTrue(
                nextMove.equals(new Move(new Position(3, 11), Mark.CROSS)) ||
                        nextMove.equals(new Move(new Position(11, 11), Mark.CROSS)),
                "Expected CROSS at (3,11) or (11,11), but got: " + nextMove
        );

    }

    static Set<Move> createBoardState8() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 11), Mark.CROSS));
        board.add(new Move(new Position(1, 11), Mark.CROSS));
        board.add(new Move(new Position(2, 11), Mark.CROSS));
        board.add(new Move(new Position(7, 11), Mark.CROSS));
        board.add(new Move(new Position(8, 11), Mark.CROSS));

        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 3), Mark.NOUGHT));
        board.add(new Move(new Position(8, 3), Mark.NOUGHT));
        board.add(new Move(new Position(10, 11), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldReturnMoveToWinInTwoWithPeriodic2() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        printBoard(createBoardState8(), Mark.NOUGHT, false, Mark.CROSS);
        Game gomoku = new Gomoku();
        gomoku.size(12);
        gomoku.periodicBoundaryConditionsInUse();
        gomoku.firstMark(Mark.NOUGHT);
        Move nextMove = gomoku.nextMove(createBoardState8(), Mark.CROSS);
        assertEquals(nextMove, new Move(new Position(3, 11), Mark.CROSS), "Expected CROSS at (3,11), but got: " + nextMove);

    }


    static Set<Move> createBoardState9() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(3, 9), Mark.CROSS));
        board.add(new Move(new Position(3, 8), Mark.CROSS));
        board.add(new Move(new Position(4, 9), Mark.CROSS));
        board.add(new Move(new Position(4, 8), Mark.CROSS));

        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 3), Mark.NOUGHT));
        board.add(new Move(new Position(8, 3), Mark.NOUGHT));

        return board;
    }

    @Test
    void testFromDiscord1() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        printBoard(createBoardState9(), Mark.NOUGHT, false, Mark.CROSS);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.NOUGHT);
            Move nextMove = gomoku.nextMove(createBoardState9(), Mark.CROSS);
            System.out.println("Expected ResignException, got " + nextMove);
        });
    }


    static Set<Move> createBoardState10() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 11), Mark.CROSS));
        board.add(new Move(new Position(1, 11), Mark.CROSS));
        board.add(new Move(new Position(3, 11), Mark.CROSS));
        board.add(new Move(new Position(7, 11), Mark.CROSS));
        board.add(new Move(new Position(8, 11), Mark.CROSS));

        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 3), Mark.NOUGHT));
        board.add(new Move(new Position(8, 3), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldResignWhenOpponentWinsInTwoMovesWithCross3() {
        printBoard(createBoardState10(), Mark.CROSS, false, Mark.CROSS);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.CROSS);
            Move nextMove = gomoku.nextMove(createBoardState10(), Mark.CROSS);
            System.out.println("Expected ResignException, got " + nextMove);
        });

    }

    static Set<Move> createBoardState11() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(4, 11), Mark.CROSS));
        board.add(new Move(new Position(1, 11), Mark.CROSS));
        board.add(new Move(new Position(3, 11), Mark.CROSS));
        board.add(new Move(new Position(7, 11), Mark.CROSS));
        board.add(new Move(new Position(8, 11), Mark.CROSS));

        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(6, 3), Mark.NOUGHT));
        board.add(new Move(new Position(8, 3), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldWinInTwoTest() throws TheWinnerIsException, ResignException, WrongBoardStateException {
        printBoard(createBoardState11(), Mark.CROSS, false, Mark.CROSS);
        Game gomoku = new Gomoku();
        gomoku.size(12);
        gomoku.firstMark(Mark.CROSS);
        Move nextMove = gomoku.nextMove(createBoardState11(), Mark.CROSS);
        assertEquals(nextMove, new Move(new Position(2, 11), Mark.CROSS), "Expected CROSS at (2,11), but got: " + nextMove);


    }

}
