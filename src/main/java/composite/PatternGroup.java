package composite;

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

    public void addPatterns(Pattern pattern) {
        patterns.add(pattern);
    }

    public void removePattern(Pattern pattern) {
        patterns.remove(pattern);
    }


    @Override
    public abstract boolean matches(Board board, DirectionStrategy strategy, Position pos, Optional<Mark> mark);
}