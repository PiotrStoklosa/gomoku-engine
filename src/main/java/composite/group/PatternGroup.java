package composite.group;

import composite.Pattern;
import factory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import strategy.DirectionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class PatternGroup implements Pattern {

    Move foundMove = null;

    protected List<Pattern> patterns = new ArrayList<>();

    @Override
    public abstract boolean matches(Board board, DirectionStrategy strategy, Position pos, Optional<Mark> mark);
}