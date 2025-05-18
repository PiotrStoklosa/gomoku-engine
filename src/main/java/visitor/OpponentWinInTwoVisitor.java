package visitor;

import factory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.ResignException;
import fais.zti.oramus.gomoku.TheWinnerIsException;
import fais.zti.oramus.gomoku.WrongBoardStateException;
import template.TemplateVisitor;

public class OpponentWinInTwoVisitor extends TemplateVisitor {
    @Override
    protected void scanForPatterns(Board board) throws TheWinnerIsException, ResignException, WrongBoardStateException {

    }

    @Override
    protected Mark findMark() {
        return null;
    }
}
