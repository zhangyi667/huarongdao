package com.medopad.game.Snapshot.moveSingle;

import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveSingleBuilder {
    public static Snapshot build(Snapshot snapshot, Direction direction) {
        switch (direction) {
            case LEFT:
                return new MoveSingleToLeft(snapshot, direction);
            case RIGHT:
                return new MoveSingleToRight(snapshot, direction);
            case UP:
                return new MoveSingleUp(snapshot, direction);
            case DOWN:
                return new MoveSingleDown(snapshot, direction);
            default:
                return null;
        }
    }
}
