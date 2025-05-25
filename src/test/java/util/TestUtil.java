package util;

import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;

import java.util.Set;

public class TestUtil {
    public static void printBoard(Set<Move> moves, Mark firstMark, boolean periodic, Mark nextMove) {
        System.out.println("-----------------------");
        Mark[][] board = new Mark[12][12];

        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 12; col++) {
                board[row][col] = Mark.NULL;
            }
        }

        for (Move move : moves) {
            int row = move.position().row();
            int col = move.position().col();
            board[row][col] = move.mark();
        }

        int countX = 0;
        int countO = 0;

        for (int row = 0; row < 12; row++) {
            for (int col = 0; col < 12; col++) {
                System.out.print(board[row][col] + " ");
                if (board[row][col] == Mark.CROSS) countX++;
                if (board[row][col] == Mark.NOUGHT) countO++;
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        System.out.println("First Mark: " + firstMark);
        if (periodic) {
            System.out.println("Periodic boundary conditions are on");
        } else {
            System.out.println("Periodic boundary conditions are off");
        }
        System.out.println("Next move: " + nextMove);
        System.out.println("Number of X: " + countX);
        System.out.println("Number of O: " + countO);
        System.out.println("-----------------------");
    }

}
