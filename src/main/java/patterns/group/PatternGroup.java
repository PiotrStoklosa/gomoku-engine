package patterns.group;

import patterns.Pattern;
import boardfactory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import strategy.DirectionStrategy;

import java.util.ArrayList;
import java.util.List;

public abstract class PatternGroup implements Pattern {

    Move foundMove = null;

    protected final List<Pattern> patterns = new ArrayList<>();

    @Override
    public abstract boolean matches(Board board, DirectionStrategy strategy, Position pos, Mark mark);
}