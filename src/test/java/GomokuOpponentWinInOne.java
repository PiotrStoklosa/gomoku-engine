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

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GomokuOpponentWinInOne {

    static Set<Move> createBoardState1() {
        Set<Move> board = new HashSet<>();

        // Random Cross
        board.add(new Move(new Position(0, 0), Mark.CROSS));
        board.add(new Move(new Position(2, 0), Mark.CROSS));
        board.add(new Move(new Position(4, 0), Mark.CROSS));
        board.add(new Move(new Position(8, 6), Mark.CROSS));


        //  NOUGHT is winning in one move
        board.add(new Move(new Position(7, 2), Mark.NOUGHT));
        board.add(new Move(new Position(7, 3), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));
        board.add(new Move(new Position(7, 5), Mark.NOUGHT));

        return board;
    }

    @Test
    void shouldResignWhenOpponentWinsWithFoursMarksInRowWithNonPeriodicBoard() throws TheWinnerIsException, ResignException, WrongBoardStateException {

        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            System.out.println(gomoku.nextMove(createBoardState1(), Mark.CROSS));
        });


    }

    static Set<Move> createBoardState2() {
        Set<Move> board = new HashSet<>();

        // Random Noughts
        board.add(new Move(new Position(0, 0), Mark.NOUGHT));
        board.add(new Move(new Position(2, 0), Mark.NOUGHT));
        board.add(new Move(new Position(4, 0), Mark.NOUGHT));
        board.add(new Move(new Position(7, 4), Mark.NOUGHT));


        //  CROSS is winning in one move
        board.add(new Move(new Position(7, 0), Mark.CROSS));
        board.add(new Move(new Position(7, 1), Mark.CROSS));
        board.add(new Move(new Position(7, 2), Mark.CROSS));
        board.add(new Move(new Position(7, 11), Mark.CROSS));

        return board;
    }


    @Test
    void shouldResignWhenOpponentWinsWithFoursMarksInRowWithPeriodicBoard() throws TheWinnerIsException, ResignException, WrongBoardStateException {

        assertThrows(ResignException.class, () -> {
            Game gomoku = new Gomoku();
            gomoku.size(12);
            gomoku.periodicBoundaryConditionsInUse();
            gomoku.nextMove(createBoardState2(), Mark.NOUGHT);
        });

    }


}
