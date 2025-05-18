import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GomokuAlreadyWonTest {

    static Set<Move> createBoardState1() {
        Set<Move> board = new HashSet<>();

        // First Win
        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(1, 0), Mark.CROSS));
        board.add(new Move(new Position(2, 0), Mark.CROSS));
        board.add(new Move(new Position(3, 0), Mark.CROSS));
        board.add(new Move(new Position(4, 0), Mark.CROSS));

        // 5 noughts
        board.add(new Move(new Position(5, 0), Mark.NOUGHT));
        board.add(new Move(new Position(6, 0), Mark.NOUGHT));
        board.add(new Move(new Position(7, 0), Mark.NOUGHT));
        board.add(new Move(new Position(8, 0), Mark.NOUGHT));
        board.add(new Move(new Position(5, 1), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldThrowTheWinnerIsExceptionWhenWinForOnePlayerWithNonPeriodicBoard() {
        TheWinnerIsException ex = assertThrows(TheWinnerIsException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.nextMove(createBoardState1(), Mark.NOUGHT);
        });
        assertEquals(Mark.CROSS, ex.mark);

    }

    static Set<Move> createBoardState2() {
        Set<Move> board = new HashSet<>();

        // First win (horizontal wrapping around right edge)
        board.add(new Move(new Position(10, 3), Mark.NOUGHT));
        board.add(new Move(new Position(11, 3), Mark.NOUGHT));
        board.add(new Move(new Position(0, 3), Mark.NOUGHT));
        board.add(new Move(new Position(1, 3), Mark.NOUGHT));
        board.add(new Move(new Position(2, 3), Mark.NOUGHT));


        // NOUGHT moves
        board.add(new Move(new Position(4, 4), Mark.CROSS));
        board.add(new Move(new Position(6, 4), Mark.CROSS));
        board.add(new Move(new Position(8, 4), Mark.CROSS));
        board.add(new Move(new Position(5, 5), Mark.CROSS));
        board.add(new Move(new Position(7, 5), Mark.CROSS));
        board.add(new Move(new Position(9, 5), Mark.CROSS));


        return board;
    }

    @Test
    void shouldThrowWrongBoardStateExceptionWhenTwoWinsForOnePlayerWithPeriodicBoard() {
        TheWinnerIsException ex = assertThrows(TheWinnerIsException.class, () -> {
            Gomoku gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.periodicBoundaryConditionsInUse();
            gomoku.nextMove(createBoardState2(), Mark.NOUGHT);
        });
        assertEquals(Mark.NOUGHT, ex.mark);
    }

}
