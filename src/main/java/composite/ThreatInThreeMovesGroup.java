package composite;

import factory.Board;
import fais.zti.oramus.gomoku.Mark;
import fais.zti.oramus.gomoku.Move;
import fais.zti.oramus.gomoku.Position;
import strategy.DirectionStrategy;

import java.util.Optional;

public class ThreatInThreeMovesGroup extends PatternGroup{

    public ThreatInThreeMovesGroup() {
        patterns.add(new CrossThreatPattern());
        patterns.add(new LThreatPattern());
    }

    @Override
    public boolean matches(Board board, DirectionStrategy strategy, Position pos, Optional<Mark> mark) {
        return false;
    }

    @Override
    public Move getFoundMove() {
        return null;
    }
}
