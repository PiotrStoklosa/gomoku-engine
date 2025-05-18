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

public class GomokuOpponentWinInOneTest {

    static Set<Move> createBoardState1() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(2, 0), Mark.CROSS));
        board.add(new Move(new Position(4, 0), Mark.CROSS));
        board.add(new Move(new Position(8, 6), Mark.CROSS));

        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(7, 5), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldResignWhenOpponentWinsWithFoursMarksInRowWithNonPeriodicBoard() {
        printBoard(createBoardState1(), Mark.CROSS, false, Mark.CROSS);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.CROSS);
            System.out.println(gomoku.nextMove(createBoardState1(), Mark.CROSS));
        });


    }

    static Set<Move> createBoardState2() {
        Set<Move> board = new HashSet<>();

        board.add(new Move(new Position(0, 0), Mark.NOUGHT));
        board.add(new Move(new Position(2, 0), Mark.NOUGHT));
        board.add(new Move(new Position(4, 0), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));

        board.add(new Move(new Position(7, 0), Mark.CROSS));
        board.add(new Move(new Position(7, 1), Mark.CROSS));
        board.add(new Move(new Position(7, 2), Mark.CROSS));
        board.add(new Move(new Position(7, 11), Mark.CROSS));

        return board;
    }


    @Test
    void shouldResignWhenOpponentWinsWithFoursMarksInRowWithPeriodicBoard() {
        printBoard(createBoardState2(), Mark.NOUGHT, true, Mark.NOUGHT);
        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.firstMark(Mark.NOUGHT);
            gomoku.periodicBoundaryConditionsInUse();
            gomoku.nextMove(createBoardState2(), Mark.NOUGHT);
        });

    }
}
